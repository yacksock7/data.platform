package choi.oop.model.results;

import choi.oop.model.results.contents.ResultContent;
import choi.oop.model.support.ResultContentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Result {
    private Long id;
//    private Long jobId;
//    private Integer jobStepNum;
//    private Integer jobStepTaskNum;
//    private Long userId;
    private Integer index;
    private LocalDateTime createdDatetime;
    private LocalDateTime updatedDatetime;

    private ResultContentType contentType;
    private ResultContent content;
}
