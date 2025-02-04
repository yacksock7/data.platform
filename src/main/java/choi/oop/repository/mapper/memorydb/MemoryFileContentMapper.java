package choi.oop.repository.mapper.memorydb;

import choi.oop.model.results.contents.FileContent;
import choi.oop.repository.mapper.FileContentMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryFileContentMapper implements FileContentMapper {

    private Map<Long, FileContent> resultMap = new ConcurrentHashMap<>();

    public synchronized void insert(FileContent content) {
        content.setCreatedDatetime(LocalDateTime.now());
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public synchronized FileContent select(Long resultId) {
        return resultMap.get(resultId);
    }

    public synchronized void update(FileContent content) {
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public synchronized void delete(Long resultId) {
        resultMap.remove(resultId);
    }
}
