package choi.oop.repository.mapper.memorydb;

import choi.oop.model.results.Result;
import choi.oop.repository.mapper.ResultMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryResultMapper implements ResultMapper {

    private Map<Long, Result> resultMap = new HashMap<>();
    private long index = 0;


    public void insert(Result result){
        result.setId(++index);
        result.setCreatedDatetime(LocalDateTime.now());
        result.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(index, result);
    }

    public Result select(Long resultId) {
        return resultMap.get(resultId);
    }

    public void update(Result result) {
        result.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(result.getId(), result);
    }

    public void delete(Long resultId) {
        resultMap.remove(resultId);
    }
}
