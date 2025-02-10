package choi.oop.service.steps.modules;

import choi.oop.model.steps.InspectModel;
import choi.oop.model.steps.StepModel;
import org.springframework.stereotype.Component;

@Component
public class InspectStep implements StepModule {
    @Override
    public void execute(StepModel stepModel) {
        // InspectStep service logic...
        final InspectModel inspectModel = (InspectModel) stepModel;
        System.out.println("InspectStep.execute");

        // TODO 전처리 business logic
        // 1. modify status to  PROCESS by jobStepTask

        // TODO TranslateStep main logic
        // 2. EMPTY

        // TODO 후처리 business logic
        // 3. modify status to COMPLETE by jobStepTask
        // 4. create next jobStepTask with WAIT status
        // 5. check next jobStep is TranslateStep or SplitStep
    }
}
