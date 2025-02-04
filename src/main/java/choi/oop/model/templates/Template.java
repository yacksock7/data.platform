package choi.oop.model.templates;

import choi.oop.model.support.TemplateType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Template {
    private Long id;
    private Long userId;
    private TemplateType type;
    private String name;
    private LocalDateTime createdDatetime;
    private LocalDateTime updatedDatetime;
}
