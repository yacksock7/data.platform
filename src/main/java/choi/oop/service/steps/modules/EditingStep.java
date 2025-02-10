package choi.oop.service.steps.modules;

import choi.oop.model.steps.EditingModel;
import choi.oop.model.steps.StepModel;
import choi.oop.service.results.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EditingStep implements StepModule {

    private final ResultService resultService;

    @Override
    public void execute(StepModel stepModel) {
        // EditingStep service logic...
        final EditingModel editingModel = (EditingModel) stepModel;
        System.out.println("EditingStep.execute");

        // TODO 전처리 business logic
        // 1. modify status to  PROCESS by jobStepTask

        // TODO TranslateStep main logic
        // 2. create Result with ResultContent

        // TODO 후처리 business logic
        // 3. modify status to COMPLETE by jobStepTask
        // 4. create next jobStepTask with WAIT status
        // 5. check next jobStep is TranslateStep or SplitStep
    }
}
