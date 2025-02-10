package choi.oop.service.steps.modules;

import choi.oop.model.steps.SplitModel;
import choi.oop.model.steps.StepModel;
import choi.oop.service.results.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SplitStep implements StepModule {

    private final ResultService resultService;

    @Override
    public void execute(StepModel stepModel) {
        // SplitStep service logic...
        final SplitModel splitModel = (SplitModel) stepModel;
        System.out.println("SplitStep.execute");

        // TODO 전처리 business logic
        // 1. modify status to  PROCESS by jobStepTask

        // TODO TranslateStep main logic
        // 2. convert file to texts
        // 3. create texts Results with ResultContent(N개의 Results 생성)

        // TODO 후처리 business logic
        // 4. modify status to COMPLETE by jobStepTask
        // 5. create next jobStepTasks with WAIT status(N개의 jobStepTasks 생성)
        // 6. check next jobStep is TranslateStep or SplitStep(N개의 jobStepTask에 대한 작업 수행)
    }
}
