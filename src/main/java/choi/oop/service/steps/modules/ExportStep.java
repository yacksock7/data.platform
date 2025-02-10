package choi.oop.service.steps.modules;

import choi.oop.model.steps.ExportModel;
import choi.oop.model.steps.StepModel;
import org.springframework.stereotype.Component;

@Component
public class ExportStep implements StepModule {
    @Override
    public void execute(StepModel stepModel) {
        // ExportStep service logic...
        final ExportModel exportModel = (ExportModel) stepModel;
        System.out.println("ExportStep.execute");

        // 1. modify status to  PROCESS by jobStepTask
        // 2. export

        // 3. modify status to COMPLETE by jobStepTask
        // 4. create next jobStepTask with WAIT status
        // 5. check next jobStep is TranslateStep or SplitStep
    }
}
