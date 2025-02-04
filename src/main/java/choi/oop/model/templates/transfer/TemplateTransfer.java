package choi.oop.model.templates.transfer;

import choi.oop.model.support.TemplateType;
import choi.oop.model.templates.TemplateStep;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class TemplateTransfer {
    private Long id;
    private Long userId;
    private TemplateType type;
    private String name;
    private LocalDateTime createdDatetime;
    private LocalDateTime updatedDatetime;

    private List<TemplateStep> steps;
}
