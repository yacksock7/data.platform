package choi.oop.repository.mapper.memorydb;

import choi.oop.model.results.contents.FileContent;
import choi.oop.repository.mapper.FileContentMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryFileContentMapper implements FileContentMapper {

    private Map<Long, FileContent> resultMap = new HashMap<>();

    public void insert(FileContent content) {
        content.setCreatedDatetime(LocalDateTime.now());
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public FileContent select(Long resultId) {
        return resultMap.get(resultId);
    }

    public void update(FileContent content) {
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public void delete(Long resultId) {
        resultMap.remove(resultId);
    }
}
