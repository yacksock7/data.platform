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
    }
}
