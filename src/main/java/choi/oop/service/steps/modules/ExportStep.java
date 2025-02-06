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
    }

    private ExportModel convert(StepModel model) {
        return null;
    }
}
