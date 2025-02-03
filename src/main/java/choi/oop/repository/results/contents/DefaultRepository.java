package choi.oop.repository.results.contents;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopServerException;
import choi.oop.model.results.contents.ResultContent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultRepository implements ResultContentRepository {

    @Override
    public void insert(ResultContent content) {
        log.error("[DefaultRepository] Failed to insert content = {}", content);
        throw new OopServerException(ErrorCode.UnmatchedType, "Can not found ResultContentRepository instance By ResultContentType.");
    }

    @Override
    public ResultContent select(Long resultId) {
        log.error("[DefaultRepository] Failed to select resultId = {}", resultId);
        throw new OopServerException(ErrorCode.UnmatchedType, "Can not found ResultContentRepository instance By ResultContentType.");
    }

    @Override
    public void update(ResultContent content) {
        log.error("[DefaultRepository] Failed to update content = {}", content);
        throw new OopServerException(ErrorCode.UnmatchedType, "Can not found ResultContentRepository instance By ResultContentType.");
    }

    @Override
    public void delete(Long resultId) {
        log.error("[DefaultRepository] Failed to delete resultId = {}", resultId);
        throw new OopServerException(ErrorCode.UnmatchedType, "Can not found ResultContentRepository instance By ResultContentType.");
    }
}
