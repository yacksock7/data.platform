package choi.oop.service.steps.modules;

import choi.oop.model.steps.StepModel;
import choi.oop.model.steps.TranslationModel;
import choi.oop.service.results.ResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TranslationStep implements StepModule {

    private final ResultService resultService;
    
    @Override
    public void execute(StepModel stepModel) {
        // MachineStep service logic...
        final TranslationModel translationModel = (TranslationModel) stepModel;
        System.out.println("TranslationStep.execute");

        // TODO 전처리 business logic
        // 1. modify status to  PROCESS by jobStepTask

        // TODO TranslateStep main logic
        // 2. translate (source -> target)
        // 3. create Result with ResultContent

        // TODO 후처리 business logic
        // 4. modify status to COMPLETE by jobStepTask
        // 5. create next jobStepTask with WAIT status
        // 6. check next jobStep is TranslateStep or SplitStep
    }
}
