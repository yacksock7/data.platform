package choi.oop.service.steps.modules;

import choi.oop.model.steps.StepModel;
import choi.oop.model.steps.UploadModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UploadStep implements StepModule {

    @Override
    public void execute(StepModel stepModel) {
        // Upload service logic...
        final UploadModel uploadModel = (UploadModel) stepModel;
        System.out.println("UploadStep.execute");

        // create job
        // create jobStep
        // create jobStepTask
        // create jobStepTaskResult

        // create cloudObjects
        // create jobStepTaskResultFile

        // modify status to COMPLETE by jobStepTask
        // create next jobStepTask with WAIT status
        // check next jobStep is TranslateStep or SplitStep
    }

    private void after() {
        // create next jobStep
        // create next jobStepTask
        // 후처리 Machine 이면 실행
    }
}
