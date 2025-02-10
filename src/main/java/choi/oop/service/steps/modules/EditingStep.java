package choi.oop.service.steps.modules;

import choi.oop.model.steps.EditingModel;
import choi.oop.model.steps.StepModel;
import org.springframework.stereotype.Component;

@Component
public class EditingStep implements StepModule {
    @Override
    public void execute(StepModel stepModel) {
        // EditingStep service logic...
        final EditingModel editingModel = (EditingModel) stepModel;
        System.out.println("EditingStep.execute");

        // 1. modify status to  PROCESS by jobStepTask
        // 2. create Result with ResultContent

        // 3. modify status to COMPLETE by jobStepTask
        // 4. create next jobStepTask with WAIT status
        // 5. check next jobStep is TranslateStep or SplitStep
    }
}
