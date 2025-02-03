package choi.oop.model.results.contents;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class ResultContent {
    private Long resultId;
    private LocalDateTime createdDatetime;
    private LocalDateTime updatedDatetime;
}
