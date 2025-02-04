package choi.oop.repository.results.manager;

import choi.oop.model.support.ResultContentType;
import choi.oop.repository.mapper.ResultContentMapper;
import choi.oop.repository.mapper.handler.ResultContentMapperHandler;
import choi.oop.repository.results.contents.ResultContentRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Repository
public class ResultContentConverter implements ResultContentManager {

    private final ResultContentMapperHandler mapperHandler = new ResultContentMapperHandler();

    private final String PREFIX = "choi.oop.repository.results.contents";
    private final String SUBFIX = "ContentRepository";

    public ResultContentRepository getRepository(ResultContentType type) {

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
