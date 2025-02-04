package choi.oop.repository.templates;

import choi.oop.model.templates.Template;
import choi.oop.repository.mapper.TemplateMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TemplateRepository {
    private final TemplateMapper mapper;

    public void insert(Template template) {
        mapper.insert(template);
    }

    public Template select(Long id) {
        return mapper.select(id);
    }
}
