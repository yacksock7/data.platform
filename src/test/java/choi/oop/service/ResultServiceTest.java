package choi.oop.service;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopAuthException;
import choi.oop.exception.OopServerException;
import choi.oop.model.results.Result;
import choi.oop.model.results.contents.FileContent;
import choi.oop.model.results.contents.ResultContent;
import choi.oop.model.results.contents.TagContent;
import choi.oop.model.results.contents.TextContent;
import choi.oop.model.support.FileType;
import choi.oop.model.support.ResultContentType;
import choi.oop.service.results.ResultContentService;
import choi.oop.service.results.ResultService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class ResultServiceTest {

    @Autowired
    ResultService resultService;
    @Autowired
    ResultContentService resultContentService;

    @Test
    @DisplayName("create Result by TextContent O")
    void create_result_by_text_O() throws OopAuthException {
        // given
        final TextContent content = new TextContent("지금까지 다녀 본 여행지 중 좋았던 곳 추천해 줘.");
        final ResultContentType contentType = ResultContentType.TEXT;
        create_result_O(contentType, content);
    }

    @Test
    @DisplayName("create Result by TagContent O")
    void create_result_by_tag_O() throws OopAuthException {
        // given
        final TagContent content = new TagContent(0, 10, "Tag 정보");
        final ResultContentType contentType = ResultContentType.TAG;
        create_result_O(contentType, content);
    }

    @Test
    @DisplayName("create Result by FileContent O")
    void create_result_by_file_O() throws OopAuthException {
        // given
        final FileContent content = new FileContent(1, FileType.WAV);
        final ResultContentType contentType = ResultContentType.FILE;
        create_result_O(contentType, content);
    }

    private void create_result_O(ResultContentType contentType, ResultContent content) throws OopAuthException  {
        // given
        final Result result = Result.builder()
                .index(1)
                .contentType(contentType)
                .content(content)
                .build();

        // when
        resultService.create(result);

        // then
        Result selectedResult = resultService.get(result.getId());
        assertThat(result.getId()).isEqualTo(selectedResult.getId());
        assertThat(result.getContentType()).isEqualTo(selectedResult.getContentType());
        assertThat(result.getContent()).isInstanceOf(selectedResult.getContent().getClass());
    }


    @Test
    @DisplayName("create Result by TextContent X")
    void create_result_by_text_X() {
        // given
        final TextContent content = new TextContent("지금까지 다녀 본 여행지 중 좋았던 곳 추천해 줘.");
        final ResultContentType contentType = ResultContentType.UNKNOWN;
        create_result_X(contentType, content);
    }

    @Test
    @DisplayName("create Result by TagContent X")
    void create_result_by_tag_X() {
        // given
        final TagContent content = new TagContent(0, 10, "Tag 정보");
        final ResultContentType contentType = ResultContentType.UNKNOWN;
        create_result_X(contentType, content);
    }

    @Test
    @DisplayName("create Result by FileContent X")
    void create_result_by_file_X() {
        // given
        final FileContent content = new FileContent(1, FileType.WAV);
        final ResultContentType contentType = ResultContentType.UNKNOWN;
        create_result_X(contentType, content);
    }

    private void create_result_X(ResultContentType contentType, ResultContent content) {
        // given
        final Result result = Result.builder()
                .index(1)
                .contentType(contentType)
                .content(content)
                .build();

        // when
        OopServerException e = assertThrows(OopServerException.class, () -> resultService.create(result));
        assertThat(ErrorCode.UnmatchedType).isEqualTo(e.getErrorCode());

        // then
    }

    @Test
    @DisplayName("modify ResultContent by TextContent O")
    void modify_result_content_by_text_O() throws OopAuthException {
        // given
        final TextContent content = new TextContent("create");
        final ResultContentType contentType = ResultContentType.TEXT;
        final Result result = Result.builder()
                .index(1)
                .contentType(contentType)
                .content(content)
                .build();
        resultService.create(result);

        // when
        content.setText("update");
        resultService.modify(result);

        //then
        Result selectedResult = resultService.get(result.getId());
        TextContent selectedContent = (TextContent) selectedResult.getContent();
        assertThat(selectedContent.getText()).isEqualTo("update");
    }

    @Test
    @DisplayName("modify ResultContent by TagContent O")
    void modify_result_content_by_tag_O() throws OopAuthException {
        // given
        final TagContent content = new TagContent(0, 10, "Tag 정보 create");
        final ResultContentType contentType = ResultContentType.TAG;
        final Result result = Result.builder()
                .index(1)
                .contentType(contentType)
                .content(content)
                .build();
        resultService.create(result);

        // when
        content.setStartIndex(11);
        content.setEndIndex(20);
        content.setTag("Tag 정보 update");
        resultService.modify(result);

        //then
        Result selectedResult = resultService.get(result.getId());
        TagContent selectedContent = (TagContent) selectedResult.getContent();
        assertThat(selectedContent.getStartIndex()).isEqualTo(11);
        assertThat(selectedContent.getEndIndex()).isEqualTo(20);
        assertThat(selectedContent.getTag()).isEqualTo("Tag 정보 update");
    }

    @Test
    @DisplayName("modify ResultContent by FileContent O")
    void modify_result_content_by_file_O() throws OopAuthException {
        // given
        final FileContent content = new FileContent(1L, FileType.WAV);
        final ResultContentType contentType = ResultContentType.FILE;
        final Result result = Result.builder()
                .index(1)
                .contentType(contentType)
                .content(content)
                .build();
        resultService.create(result);

        // when
        content.setFileId(2L);
        content.setType(FileType.CSV);
        resultService.modify(result);

        //then
        Result selectedResult = resultService.get(result.getId());
        FileContent selectedContent = (FileContent) selectedResult.getContent();
        assertThat(selectedContent.getFileId()).isEqualTo(2L);
        assertThat(selectedContent.getType()).isEqualTo(FileType.CSV);
    }

    @Test
    @DisplayName("remove ResultContent by Text O")
    void remove_result_content_by_text_O() {
        // given
        final TextContent content = new TextContent("create");
        final ResultContentType contentType = ResultContentType.TEXT;
        remove_result(contentType, content);
    }

    @Test
    @DisplayName("remove ResultContent by Tag O")
    void remove_result_content_by_tag_O() {
        // given
        final TagContent content = new TagContent(0, 10, "Tag 정보 create");
        final ResultContentType contentType = ResultContentType.TAG;
        remove_result(contentType, content);
    }

    @Test
    @DisplayName("remove ResultContent by FileContent O")
    void remove_result_content_by_file_O() {
        // given
        final FileContent content = new FileContent(1L, FileType.WAV);
        final ResultContentType contentType = ResultContentType.FILE;
        remove_result(contentType, content);
    }

    private void remove_result(ResultContentType contentType, ResultContent content) {
        // given
        final Result result = Result.builder()
                .index(1)
                .contentType(contentType)
                .content(content)
                .build();
        resultService.create(result);

        // when
        resultService.remove(result.getId());

        //then
        OopAuthException e = assertThrows(OopAuthException.class, () -> resultService.get(result.getId()));
        assertThat(ErrorCode.NotFound).isEqualTo(e.getErrorCode());

        ResultContent selectedContent = resultContentService.get(contentType, result.getId());
        assertThat(selectedContent).isNull();
    }


}