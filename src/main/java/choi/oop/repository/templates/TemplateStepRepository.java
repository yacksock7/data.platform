package choi.oop.repository.templates;

import choi.oop.model.templates.TemplateStep;
import choi.oop.repository.mapper.TemplateStepMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TemplateStepRepository {

    private final TemplateStepMapper mapper;

    public void insert(TemplateStep step) {
        mapper.insert(step);
    }

    public List<TemplateStep> select(Long templateId) {
        return mapper.selectByTemplateId(templateId);
    };


}
