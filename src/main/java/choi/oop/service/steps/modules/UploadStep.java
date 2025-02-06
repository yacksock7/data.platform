package choi.oop.service.steps.modules;

import choi.oop.model.steps.StepModel;
import choi.oop.model.steps.UploadModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UploadStep implements StepModule {
    @Override
    public void execute(StepModel model) {
        // Upload service logic...
    }

    private UploadModel convert(StepModel model) {
        return (UploadModel) model;
    }
}
