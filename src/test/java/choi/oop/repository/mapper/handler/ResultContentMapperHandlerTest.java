package choi.oop.repository.mapper.handler;

import choi.oop.model.support.ResultContentType;
import choi.oop.repository.mapper.memorydb.MemoryTextContentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultContentMapperHandlerTest {

    private ResultContentMapperHandler mapperHandler = new ResultContentMapperHandler();
    

    @Test
    @DisplayName("get mapper instance by ResultContentType")
    void get_mapper_by_content_type() {
        // given
        final ResultContentType contentType = ResultContentType.TEXT;

        // when
        Object mapper = mapperHandler.getMapper(contentType);

        // then
        System.out.println("mapper = " + mapper);
        assertThat(mapper.getClass()).isEqualTo(MemoryTextContentMapper.class);
    }

}