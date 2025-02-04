package choi.oop.repository.results;

import choi.oop.model.support.ResultContentType;
import choi.oop.repository.results.contents.ResultContentRepository;
import choi.oop.repository.results.manager.ResultContentManager;
import choi.oop.repository.results.manager.ResultContentConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultContentConverterTest {

    private ResultContentManager repositoryHandler = new ResultContentConverter();
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