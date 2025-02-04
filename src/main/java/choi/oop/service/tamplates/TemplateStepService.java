package choi.oop.service.tamplates;

import choi.oop.model.templates.TemplateStep;
import choi.oop.repository.templates.TemplateStepRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TemplateStepService {

    private final TemplateStepRepository templateStepRepository;

    public void create(Long templateId, List<TemplateStep> steps) {
        steps.forEach((step) -> {
            step.setTemplateId(templateId);
            create(step);
        });
    }

    public void create(TemplateStep step) {
        templateStepRepository.insert(step);
    }
    public List<TemplateStep> get(Long templateId) {
        return templateStepRepository.select(templateId);
    }


}
