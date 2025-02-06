package choi.oop.service.steps.modules;

import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopServerException;
import choi.oop.model.steps.StepModel;

public class DefaultModule implements StepModule {

    @Override
    public void execute(StepModel model) {
        throw new OopServerException(ErrorCode.UnmatchedType, "");
    }
}
