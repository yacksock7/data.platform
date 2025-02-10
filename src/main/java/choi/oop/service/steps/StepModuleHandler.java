package choi.oop.service.steps;

import choi.oop.controller.StepController;
import choi.oop.exception.ErrorCode;
import choi.oop.exception.OopServerException;
import choi.oop.model.support.TemplateStepType;
import choi.oop.service.steps.modules.DefaultModule;
import choi.oop.service.steps.modules.StepModule;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StepModuleHandler {
    private final Map<String, StepModule> moduleMap;
    private final StepModule defaultModule = new DefaultModule();
    private final String SUFFIX = "Step";

    public StepModule get(TemplateStepType type) {
        final String key = type.name().toLowerCase() + SUFFIX;
        return moduleMap.getOrDefault(key, defaultModule);
    }



    /**
     * Verification - application 실행 시 체크
     *  TemplateStepType 이 추가되면, (제약 조건...)
     *      1. StepModule 구현체가 추가되어야한다.
     *      2. Controller에 @PostMapping(value = "/steps/tasks", params = "templateStepType={TemplateStepType}")
     */
    @PostConstruct
    public void verification() {
        final Set<String> methodSet = getMethods();
        List.of(TemplateStepType.values())
                .stream()
                .forEach(type -> {

                    // 1. StepModule 구현체가 추가되어야한다.
                    final String key = type.name().toLowerCase() + SUFFIX;
                    StepModule stepModule = moduleMap.get(key);
                    if (stepModule == null) {
                        throw new OopServerException(ErrorCode.UnmatchedType, "There are no StepModule components matching the TemplateStepType. type="+type);
                    }

                    // 2. Controller에 @PostMapping(value = "/steps/tasks", params = "templateStepType={TemplateStepType}")
                    if (!methodSet.contains(type.name())) {
                        throw new OopServerException(ErrorCode.UnmatchedType, "There are no methods annotated with TemplateStepType. type="+type);
                    }
                });
    }

    private Set<String> getMethods() {
        List<String> methods =
                List.of(StepController.class.getDeclaredMethods())
                        .stream()
                        .map(method -> {
                            String[] params = method.getAnnotation(PostMapping.class).params();
                            return params[0].split("=")[1];
                        }).collect(Collectors.toList());

        return new HashSet<>(methods);
    }
}
