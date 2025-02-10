package choi.oop.service.steps.modules;

import choi.oop.model.steps.StepModel;
import choi.oop.model.steps.TranslationModel;
import org.springframework.stereotype.Component;

@Component
public class TranslationStep implements StepModule {
    @Override
    public void execute(StepModel stepModel) {
        // MachineStep service logic...
        final TranslationModel translationModel = (TranslationModel) stepModel;
        System.out.println("TranslationStep.execute");
    }
}
