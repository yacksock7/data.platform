package choi.oop.service;

import choi.oop.model.Work;
import choi.oop.model.support.TemplateType;
import choi.oop.model.templates.transfer.TemplateTransfer;
import choi.oop.repository.WorkRepository;
import choi.oop.service.tamplates.TemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkService {
    private final WorkRepository workRepository;
    private final TemplateService templateService;

    public void create(Work work) {
        Long templateId = templateService.copy(work.getTemplateId(), TemplateType.WORK);

        // create work;
        work.setTemplateId(templateId);
        workRepository.insert(work);
    }
}
