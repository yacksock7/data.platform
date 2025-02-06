package choi.oop.service.steps;

import choi.oop.model.support.TemplateStepType;
import choi.oop.service.steps.modules.DefaultModule;
import choi.oop.service.steps.modules.StepModule;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StepModuleHandler {
    private final Map<String, StepModule> moduleMap = new HashMap<>();
    private final StepModule defaultModule = new DefaultModule();
    private final String SUFFIX = "Step";

    public StepModule get(TemplateStepType type) {
        final String key = type.name().toLowerCase() + SUFFIX;
        return moduleMap.getOrDefault(key, defaultModule);
    }

}
