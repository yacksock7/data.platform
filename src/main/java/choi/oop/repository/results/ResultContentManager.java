package choi.oop.repository.results;

import choi.oop.model.support.ResultContentType;
import choi.oop.repository.results.contents.DefaultRepository;
import choi.oop.repository.results.contents.ResultContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ResultContentManager {
    private final Map<String, ResultContentRepository> repositories;
    private final ResultContentRepository defaultRepository = new DefaultRepository();
    private final String SUFFIX = "ContentRepository";

    public ResultContentRepository getRepository(ResultContentType type) {
        final String key = type.name().toLowerCase() + SUFFIX;
        return repositories.getOrDefault(key, defaultRepository);
    }
}
