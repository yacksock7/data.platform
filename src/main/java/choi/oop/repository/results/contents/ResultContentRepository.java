package choi.oop.repository.results.contents;

import choi.oop.model.results.contents.ResultContent;

public interface ResultContentRepository {
    void insert(ResultContent resultContent);
    ResultContent select(Long resultId);
    void update(ResultContent resultContent);
    void delete(Long resultId);
}
