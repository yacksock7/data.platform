package choi.oop.model.steps;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadModel extends StepModel {
    private Long userId;
    private Long workId;
    private Long templateId;
    private Integer templateStepNum;
    private List<MultipartFile> files;

    public UploadModel(Long userId, Long workId, Long templateId, Integer templateStepNum, List<MultipartFile> files) {
        this.userId = userId;
        this.workId = workId;
        this.templateId = templateId;
        this.templateStepNum = templateStepNum;
        this.files = files;
    }
}
