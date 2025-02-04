package choi.oop.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Work {
    private Long id;
    private Long userId;
    private Long templateId;
    private String name;
    private LocalDateTime createdDatetime;
    private LocalDateTime updatedDatetime;
}
