package choi.oop.repository.results;

import choi.oop.model.support.ResultContentType;
import choi.oop.repository.results.contents.ResultContentRepository;
import choi.oop.repository.results.manager.ResultContentManager;
import choi.oop.repository.results.manager.ResultContentConverterV1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultContentConverterV1Test {

    private ResultContentManager repositoryHandler = new ResultContentConverterV1();
    @Test
    @DisplayName("get repository instance by ResultContentType")
    void get_repository_by_content_type() {
        // given
        final ResultContentType contentType = ResultContentType.TEXT;

        // when
        ResultContentRepository repository = repositoryHandler.getRepository(contentType);
        System.out.println("repository = " + repository);

        // then

    }

}