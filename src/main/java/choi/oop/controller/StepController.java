package choi.oop.controller;

import choi.oop.model.steps.*;
import choi.oop.model.support.TemplateStepType;
import choi.oop.service.steps.StepModuleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/jobs")
@AllArgsConstructor
public class StepController {
    private final StepModuleService stepModuleService;

    @PostMapping(value = "/steps/tasks", params = "templateStepType=UPLOAD")
    public void execute(HttpServletRequest request,
                        @RequestParam TemplateStepType templateStepType,
                        @RequestBody UploadModel model) {
        stepModuleService.execute(templateStepType, model);
    }

    @PostMapping(value = "/steps/tasks", params = "templateStepType=MACHINE")
    public void execute(HttpServletRequest request,
                        @RequestParam TemplateStepType templateStepType,
                        @RequestBody MachineModel model) {
        stepModuleService.execute(templateStepType, model);
    }

    @PostMapping(value = "/steps/tasks", params = "templateStepType=EDITING")
    public void execute(HttpServletRequest request,
                        @RequestParam TemplateStepType templateStepType,
                        @RequestBody EditingModel model) {
        stepModuleService.execute(templateStepType, model);
    }

    @PostMapping(value = "/steps/tasks", params = "templateStepType=INSPECT")
    public void execute(HttpServletRequest request,
                        @RequestParam TemplateStepType templateStepType,
                        @RequestBody InspectModel model) {
        stepModuleService.execute(templateStepType, model);
    }

    @PostMapping(value = "/steps/tasks", params = "templateStepType=EXPORT")
    public void execute(HttpServletRequest request,
                        @RequestParam TemplateStepType templateStepType,
                        @RequestBody ExportModel model) {
        stepModuleService.execute(templateStepType, model);
    }
}
