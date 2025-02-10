package choi.oop.service.steps.modules;

import choi.oop.model.steps.StepModel;
import choi.oop.model.steps.UploadModel;
import choi.oop.service.results.ResultService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UploadStep implements StepModule {

    private final ResultService resultService;

    @Override
    public void execute(StepModel stepModel) {
        // Upload service logic...
        final UploadModel uploadModel = (UploadModel) stepModel;
        System.out.println("UploadStep.execute");


        // TODO 전처리 business logic
        // create job
        // create jobStep. All of TemplateSteps in Template
        // create jobStepTask
        // create jobStepTaskResult

        // TODO StepModule main logic
        // create cloudObjects
        // create jobStepTaskResultFile

        // TODO 후처리 business logic
        // modify status to COMPLETE by jobStepTask
        // create next jobStepTask with WAIT status
        // check next jobStep is TranslateStep or SplitStep
    }
}
