package choi.oop.repository.results.manager;

import choi.oop.model.support.ResultContentType;
import choi.oop.repository.results.contents.ResultContentRepository;

public interface ResultContentManager {
    ResultContentRepository getRepository(ResultContentType type);
}
