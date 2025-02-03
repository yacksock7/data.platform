package choi.oop.repository.results.contents;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopServerException;
import choi.oop.model.results.contents.FileContent;
import choi.oop.model.results.contents.ResultContent;
import choi.oop.repository.mapper.FileContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileContentRepository implements ResultContentRepository {

    private FileContentMapper mapper;

    @Autowired
    public FileContentRepository(FileContentMapper mapper) {
        this.mapper = mapper;
    };

    @Override
    public void insert(ResultContent content) {
        if (content instanceof FileContent file) {
            mapper.insert(file);
        } else {
            throw new OopServerException(ErrorCode.Unknown, "Unmatched instance type with ResultContent. Required type is FileContent. But provided Object Info=" + content);
        }
    }

    @Override
    public ResultContent select(Long resultId) {
        return mapper.select(resultId);
    }

    @Override
    public void update(ResultContent content) {
        if (content instanceof FileContent file) {
            mapper.update(file);
        } else {
            throw new OopServerException(ErrorCode.Unknown, "Unmatched instance type with ResultContent. Required type is FileContent. But provided Object Info=" + content);
        }
    }

    @Override
    public void delete(Long resultId) {
        mapper.delete(resultId);
    }
}
