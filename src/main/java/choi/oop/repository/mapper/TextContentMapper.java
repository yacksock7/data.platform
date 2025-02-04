package choi.oop.repository.mapper;

import choi.oop.model.results.contents.TextContent;

public interface TextContentMapper extends ResultContentMapper {

    void insert(TextContent content);

    TextContent select(Long resultId);

    void update(TextContent content);

    void delete(Long resultId);
}
