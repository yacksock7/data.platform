package choi.oop.repository.mapper;

import choi.oop.model.results.Result;

public interface ResultMapper {
    void insert(Result result);

    Result select(Long resultId);

    void update(Result result);

    void delete(Long resultId);
}
