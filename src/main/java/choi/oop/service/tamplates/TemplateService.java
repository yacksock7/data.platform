package choi.oop.service.tamplates;

import choi.oop.model.support.TemplateType;
import choi.oop.model.templates.Template;
import choi.oop.model.templates.TemplateStep;
import choi.oop.model.templates.transfer.TemplateTransfer;
import choi.oop.repository.templates.TemplateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TemplateService {

    private final TemplateRepository templateRepository;
    private final TemplateStepService templateStepService;
    private final ModelMapper modelMapper;


    public Long copy(Long id, TemplateType type) {
        final TemplateTransfer transfer =
                selectTransfer(id).toBuilder()
                        .type(type)
                        .build();

        return createTransfer(transfer);
    }

    public Long createTransfer(TemplateTransfer transfer) {

        Template template = modelMapper.map(transfer, Template.class);
        create(template);

        templateStepService.create(template.getId(), transfer.getSteps());
        return template.getId();
    }

    public void create(Template template) {
        templateRepository.insert(template);
    }

    public TemplateTransfer selectTransfer(Long id) {
        Template template = templateRepository.select(id);
        List<TemplateStep> steps = templateStepService.get(id);

        return modelMapper.map(template, TemplateTransfer.class).toBuilder()
                .steps(steps)
                .build();
    }


}
