package choi.oop.model.steps;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadModel extends StepModel {
    private Long userId;
    private Long workId;
    private Long workTemplateId;
    private Integer workTemplateStepNum;
    private List<MultipartFile> files;

    public UploadModel(Long userId, Long workId, Long workTemplateId, Integer workTemplateStepNum, List<MultipartFile> files) {
        this.userId = userId;
        this.workId = workId;
        this.workTemplateId = workTemplateId;
        this.workTemplateStepNum = workTemplateStepNum;
        this.files = files;
    }
}
