package choi.oop.repository.mapper;

import choi.oop.model.results.Result;
import choi.oop.model.results.contents.TextContent;

public interface TextContentMapper {

    void insert(TextContent content);

    TextContent select(Long resultId);

    void update(TextContent content);

    void delete(Long resultId);
}
