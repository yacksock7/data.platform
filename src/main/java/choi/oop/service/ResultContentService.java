package choi.oop.service;

import choi.oop.model.results.contents.ResultContent;
import choi.oop.model.support.ResultContentType;
import choi.oop.repository.results.manager.ResultContentManager;
import choi.oop.repository.results.contents.ResultContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultContentService {
    private final ResultContentManager resultContentManager;

    public void create(ResultContentType type, ResultContent content) {
        final ResultContentRepository repository = resultContentManager.getRepository(type);
        repository.insert(content);
    }

    public ResultContent get(ResultContentType type, Long resultId) {
        final ResultContentRepository repository = resultContentManager.getRepository(type);
        return repository.select(resultId);
    }

    public void modify(ResultContentType type, ResultContent content) {
        final ResultContentRepository repository = resultContentManager.getRepository(type);
        repository.update(content);
    }

    public void remove(ResultContentType type, Long resultId) {
        final ResultContentRepository repository = resultContentManager.getRepository(type);
        repository.delete(resultId);
    }

}
