package choi.oop.repository.mapper.memorydb;

import choi.oop.model.results.Result;
import choi.oop.repository.mapper.ResultMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MemoryResultMapper implements ResultMapper {

    private Map<Long, Result> resultMap = new ConcurrentHashMap<>();
    private AtomicLong index = new AtomicLong() ;


    public synchronized void insert(Result result){
        result.setId(index.incrementAndGet());
        result.setCreatedDatetime(LocalDateTime.now());
        result.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(index.get(), result);
    }

    public synchronized Result select(Long resultId) {
        return resultMap.get(resultId);
    }

    public synchronized void update(Result result) {
        result.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(result.getId(), result);
    }

    public synchronized void delete(Long resultId) {
        resultMap.remove(resultId);
    }
}
