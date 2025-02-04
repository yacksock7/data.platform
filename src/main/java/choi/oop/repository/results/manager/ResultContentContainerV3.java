package choi.oop.repository.results.manager;

import choi.oop.model.support.ResultContentType;
import choi.oop.repository.mapper.ResultContentMapper;
import choi.oop.repository.mapper.handler.ResultContentMapperHandler;
import choi.oop.repository.results.contents.DefaultRepository;
import choi.oop.repository.results.contents.ResultContentRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ResultContentContainerV3 implements ResultContentManager {

    /**
     * 기존 ResultContentContainerV2에 Null Object pattern을 적용하여 코드를 간결히하였다.
     *
     * DefaultRepository로 ResultContentType의 Unmatching case를 포워딩하였다.
     * getRepository() 메서드 내에서 Map class에서 제공하는 getOrDefault(); 메서드와 접목하니 코드의 가독성이 올라갔다.
     */

    private final Map<ResultContentType, ResultContentRepository> repositories = new HashMap<>();
    private final ResultContentRepository defaultRepository = new DefaultRepository();
    private final ResultContentMapperHandler mapperHandler = new ResultContentMapperHandler();
    private final String PREFIX = "choi.oop.repository.results.contents";
    private final String SUBFIX = "ContentRepository";

    public ResultContentContainerV3() {
        initRepositories();
    }

    public ResultContentRepository getRepository(ResultContentType type) {
        return repositories.getOrDefault(type, defaultRepository);
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
