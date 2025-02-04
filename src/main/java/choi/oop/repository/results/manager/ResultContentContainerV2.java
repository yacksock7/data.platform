package choi.oop.repository.results.manager;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopServerException;
import choi.oop.model.support.ResultContentType;
import choi.oop.repository.mapper.ResultContentMapper;
import choi.oop.repository.mapper.handler.ResultContentMapperHandler;
import choi.oop.repository.results.contents.ResultContentRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ResultContentContainerV2 implements ResultContentManager {

    /**
     * 기존 ResultContentConverterV1에 문제들을 개선하였다.
     *
     * Request가 발생할때마다 instance를 조회하여 호출하면, O(n)의 성능으로
     * 추후에 ResultContentRepository의 구현체가 다양해지변 성능이 나빠지는 기술부체였다.
     *
     * 2가지 방법으로 수정하였다.
     * 1. repository instance의 초기화 시점을 어플리케이션이 실행될시점으로 수정하였다.
     * 2. Map을 이용하여 key, value 형식으로 instance를 관리하는 Command Pattern을 적용하였다.
     *
     * 결론적으로, O(n)이었던 성능을 O(1)로 개선할 수 있었다.
     */

    private final Map<ResultContentType, ResultContentRepository> repositories = new HashMap<>();
    private final ResultContentMapperHandler mapperHandler = new ResultContentMapperHandler();
    private final String PREFIX = "choi.oop.repository.results.contents";
    private final String SUBFIX = "ContentRepository";

    public ResultContentContainerV2() {
        initRepositories();
    }

    public ResultContentRepository getRepository(ResultContentType type) {

        ResultContentRepository repository = repositories.get(type);
        if (repository != null) {
            return repository;
        } else {
            throw new OopServerException(ErrorCode.UnmatchedType, "Can not found ResultContentRepository by ResultContentType. type="+type);
        }
    }

    private void initRepositories() {
        List<ResultContentType> types = Arrays.asList(ResultContentType.class.getEnumConstants());
        types.forEach((type) -> {
            if (!type.equals(ResultContentType.UNKNOWN)) {
                repositories.put(type, initInstance(type));
            }
        });
    }

    private ResultContentRepository initInstance(ResultContentType type) {
        final Object mapper = mapperHandler.getMapper(type);
        final String className = getClassName(type);

        try {
            Class<?> aClass = Class.forName(className);
            Constructor<?> constructor = aClass.getDeclaredConstructor(ResultContentMapper.class);
            return (ResultContentRepository) constructor.newInstance(mapper);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private String getClassName(ResultContentType type) {
        return String.format("%s.%s%s", PREFIX, type.getValue(), SUBFIX);
    }
}
