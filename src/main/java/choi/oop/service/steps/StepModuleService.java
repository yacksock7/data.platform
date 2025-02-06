package choi.oop.service.steps;

import choi.oop.model.results.Result;
import choi.oop.model.steps.StepModel;
import choi.oop.model.support.TemplateStepType;
import choi.oop.service.results.ResultService;
import choi.oop.service.steps.modules.StepModule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StepModuleService {
    private final StepModuleHandler handler;
    private final ResultService resultService;

    public void execute(TemplateStepType type, StepModel model) {
        StepModule stepModule = handler.get(type);
        stepModule.execute(model);
    }

    public Result get(Long resultId) {
        return resultService.get(resultId);
    }

    public void modify(Result result) {
        resultService.modify(result);
    }

    public void remove(Long resultId) {
        resultService.remove(resultId);
    }

}
