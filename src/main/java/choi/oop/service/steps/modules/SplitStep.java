package choi.oop.service.steps.modules;

import choi.oop.model.steps.SplitModel;
import choi.oop.model.steps.StepModel;
import org.springframework.stereotype.Component;

@Component
public class SplitStep implements StepModule {
    @Override
    public void execute(StepModel model) {
        // SplitStep service logic...
    }


    private SplitModel convert(StepModel model) {
        return null;
    }
}
