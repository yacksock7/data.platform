package choi.oop.repository.mapper.memorydb;

import choi.oop.model.results.contents.TextContent;
import choi.oop.repository.mapper.TextContentMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Qualifier("TEXT")
public class MemoryTextContentMapper implements TextContentMapper {

    private Map<Long, TextContent> resultMap = new HashMap<>();

    private static TextContentMapper mapper = new MemoryTextContentMapper();
    private MemoryTextContentMapper() {}
    public static TextContentMapper getInstance() {
        return mapper;
    }

    public void insert(TextContent content){
        content.setCreatedDatetime(LocalDateTime.now());
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public TextContent select(Long resultId) {
        return resultMap.get(resultId);
    }

    public void update(TextContent content) {
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public void delete(Long resultId) {
        resultMap.remove(resultId);
    }
}
