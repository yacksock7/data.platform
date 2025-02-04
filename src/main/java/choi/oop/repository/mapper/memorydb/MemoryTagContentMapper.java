package choi.oop.repository.mapper.memorydb;

import choi.oop.model.results.contents.TagContent;
import choi.oop.repository.mapper.TagContentMapper;
import choi.oop.repository.mapper.TextContentMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Qualifier("TAG")
public class MemoryTagContentMapper implements TagContentMapper {

    private Map<Long, TagContent> resultMap = new HashMap<>();

    private static TagContentMapper mapper = new MemoryTagContentMapper();
    private MemoryTagContentMapper() {}
    public static TagContentMapper getInstance() {
        return mapper;
    }

    public void insert(TagContent content){
        content.setCreatedDatetime(LocalDateTime.now());
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public TagContent select(Long resultId) {
        return resultMap.get(resultId);
    }

    public void update(TagContent content) {
        content.setUpdatedDatetime(LocalDateTime.now());
        resultMap.put(content.getResultId(), content);
    }

    public void delete(Long resultId) {
        resultMap.remove(resultId);
    }
}
