package choi.oop.model.templates;

import choi.oop.model.support.ResultContentType;
import choi.oop.model.support.TemplateStepType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TemplateStep {
    private Long templateId;
    private Integer templateStepNum;
    private TemplateStepType type;
    private String name;
    private String options;
    private ResultContentType inputType;
    private ResultContentType resultType;
    private boolean isRejectPoint;
    private LocalDateTime createdDatetime;
    private LocalDateTime updatedDatetime;


}
