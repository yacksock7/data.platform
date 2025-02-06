package choi.oop.service.steps.modules;

import choi.oop.model.steps.EditingModel;
import choi.oop.model.steps.StepModel;
import org.springframework.stereotype.Component;

@Component
public class EditingStep implements StepModule {
    @Override
    public void execute(StepModel model) {
        // EditingStep service logic...
    }

    private EditingModel convert(StepModel model) {
        return null;
    }
}
