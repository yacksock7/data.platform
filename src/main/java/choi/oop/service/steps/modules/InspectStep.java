package choi.oop.service.steps.modules;

import choi.oop.model.steps.InspectModel;
import choi.oop.model.steps.StepModel;
import org.springframework.stereotype.Component;

@Component
public class InspectStep implements StepModule {
    @Override
    public void execute(StepModel model) {
        // InspectStep service logic...
    }

    private InspectModel convert(StepModel model) {
        return null;
    }
}
