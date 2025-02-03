package choi.oop.repository.results.contents;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopServerException;
import choi.oop.model.results.contents.ResultContent;
import choi.oop.model.results.contents.TextContent;
import choi.oop.repository.mapper.TextContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TextContentRepository implements ResultContentRepository {

    private TextContentMapper mapper;

    @Autowired
    public TextContentRepository(TextContentMapper mapper) {
        this.mapper = mapper;
    };

    @Override
    public void insert(ResultContent content) {
        if (content instanceof TextContent text) {
            mapper.insert(text);
        } else {
            throw new OopServerException(ErrorCode.Unknown, "Unmatched instance type with ResultContent. Required type is TextContent. But provided Object Info=" + content);
        }
    }

    @Override
    public ResultContent select(Long resultId) {
        return mapper.select(resultId);
    }

    @Override
    public void update(ResultContent content) {
        if (content instanceof TextContent text) {
            mapper.update(text);
        } else {
            throw new OopServerException(ErrorCode.Unknown, "Unmatched instance type with ResultContent. Required type is TextContent. But provided Object Info=" + content);
        }
    }

    @Override
    public void delete(Long resultId) {
        mapper.delete(resultId);
    }
}
