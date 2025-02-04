package choi.oop.repository.mapper.memorydb;

import choi.oop.model.results.contents.TextContent;
import choi.oop.repository.mapper.TextContentMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryTextContentMapper implements TextContentMapper {

    private Map<Long, TextContent> resultMap = new ConcurrentHashMap<>();

    public synchronized void insert(TextContent content){
        content.setCreatedDatetime(LocalDateTime.now());
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public synchronized TextContent select(Long resultId) {
        return resultMap.get(resultId);
    }

    public synchronized void update(TextContent content) {
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public synchronized void delete(Long resultId) {
        resultMap.remove(resultId);
    }
}
