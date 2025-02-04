package choi.oop.repository.mapper;

import choi.oop.model.results.contents.TagContent;

public interface TagContentMapper extends ResultContentMapper {

    void insert(TagContent content);

    TagContent select(Long resultId);

    void update(TagContent content);

    void delete(Long resultId);
}
