package choi.oop.service.steps.modules;

import choi.oop.model.steps.MachineModel;
import choi.oop.model.steps.StepModel;
import org.springframework.stereotype.Component;

@Component
public class MachineStep implements StepModule {
    @Override
    public void execute(StepModel stepModel) {
        // MachineStep service logic...
        final MachineModel machineModel = (MachineModel) stepModel;
        System.out.println("MachineStep.execute");
    }
}
