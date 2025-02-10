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

        // TODO 전처리 business logic
        // 1. modify status to  PROCESS by jobStepTask

        // TODO TranslateStep main logic
        // 2. export

        // TODO 후처리 business logic
        // 3. modify status to COMPLETE by jobStepTask
    }
}
