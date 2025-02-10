package choi.oop.service.steps.modules;

import choi.oop.model.steps.SplitModel;
import choi.oop.model.steps.StepModel;
import org.springframework.stereotype.Component;

@Component
public class SplitStep implements StepModule {
    @Override
    public void execute(StepModel stepModel) {
        // SplitStep service logic...
        final SplitModel splitModel = (SplitModel) stepModel;
        System.out.println("SplitStep.execute");

        // 1. modify status to  PROCESS by jobStepTask
        // 2. create Result with ResultContent

        // 3. modify status to COMPLETE by jobStepTask
        // 4. create next jobStepTask with WAIT status
        // 5. check next jobStep is TranslateStep or SplitStep
    }
}
