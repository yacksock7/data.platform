package choi.oop.repository.results;

import choi.oop.model.results.Result;
import choi.oop.repository.mapper.ResultMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResultRepository {

    private final ResultMapper resultMapper;

    public void insert(Result result) {
        resultMapper.insert(result);
    }

    public Result select(Long resultId) {
        return resultMapper.select(resultId);
    }

    public void update(Result result) {
        resultMapper.update(result);
    }

    public void delete(Long resultId) {
        resultMapper.delete(resultId);
    }

}
