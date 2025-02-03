package choi.oop.repository.results.contents;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopServerException;
import choi.oop.model.results.contents.ResultContent;
import choi.oop.model.results.contents.TagContent;
import choi.oop.repository.mapper.TagContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TagContentRepository implements ResultContentRepository {

    private TagContentMapper mapper;

    @Autowired
    public TagContentRepository(TagContentMapper mapper) {
        this.mapper = mapper;
    };

    @Override
    public void insert(ResultContent content) {
        if (content instanceof TagContent tag) {
            mapper.insert(tag);
        } else {
            throw new OopServerException(ErrorCode.UnmatchedType, "Unmatched instance type with ResultContent. Required type is TagContent. But provided Object Info=" + content);
        }
    }

    @Override
    public ResultContent select(Long resultId) {
        return mapper.select(resultId);
    }

    @Override
    public void update(ResultContent content) {
        if (content instanceof TagContent tag) {
            mapper.update(tag);
        } else {
            throw new OopServerException(ErrorCode.UnmatchedType, "Unmatched instance type with ResultContent. Required type is TagContent. But provided Object Info=" + content);
        }
    }

    @Override
    public void delete(Long resultId) {
        mapper.delete(resultId);
    }
}
