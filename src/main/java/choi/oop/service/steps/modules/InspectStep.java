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
    }

    private InspectModel convert(StepModel model) {
        return null;
    }
}
