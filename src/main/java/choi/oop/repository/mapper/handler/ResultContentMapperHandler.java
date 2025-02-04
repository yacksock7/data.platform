package choi.oop.repository.mapper.handler;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopServerException;
import choi.oop.model.support.ResultContentType;
import choi.oop.repository.mapper.ResultContentMapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ResultContentMapperHandler {
    private final String PREFIX = "choi.oop.repository.mapper.memorydb.Memory";
    private final String SUBFIX = "ContentMapper";

    public Object getMapper(ResultContentType type) {

        final String className = getClassName(type);
        try {
            Class<?> aClass = Class.forName(className);
            Method method = aClass.getDeclaredMethod("getInstance");
            return method.invoke(null);

        } catch (ClassNotFoundException e) {
            throw new OopServerException(ErrorCode.UnmatchedType, "Can not found ResultContentMapper by ResultContentType. (hint: ResultContentType="+type+")");
        } catch (NoSuchMethodException e) {
            throw new OopServerException(ErrorCode.NotFound, "Can not found method 'getInstance()' in ResultContentMapper. (hint: ResultContentType="+type+")");
        } catch (InvocationTargetException e) {
            throw new OopServerException(ErrorCode.Unknown, "Failed invoke method 'getInstance()' in ResultContentMapper. (hint: ResultContentType="+type+")");
        } catch (IllegalAccessException e) {
            throw new OopServerException(ErrorCode.Unknown, "Can not access method 'getInstance()' in ResultContentMapper. (hint: ResultContentType="+type+")");
        }
    }

    private String getClassName(ResultContentType type) {
        return String.format("%s%s%s", PREFIX, type.getValue(), SUBFIX);
    }
}
