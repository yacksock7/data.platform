package choi.oop.repository.mapper.memorydb;

import choi.oop.model.results.contents.TagContent;
import choi.oop.repository.mapper.TagContentMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryTagContentMapper implements TagContentMapper {

    private Map<Long, TagContent> resultMap = new ConcurrentHashMap<>();

    public synchronized void insert(TagContent content){
        content.setCreatedDatetime(LocalDateTime.now());
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public synchronized TagContent select(Long resultId) {
        return resultMap.get(resultId);
    }

    public synchronized void update(TagContent content) {
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public synchronized void delete(Long resultId) {
        resultMap.remove(resultId);
    }
}
