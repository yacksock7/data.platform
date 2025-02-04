package choi.oop.repository.mapper;

import choi.oop.model.templates.TemplateStep;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TemplateStepMapper {

    void insert(TemplateStep step);
    List<TemplateStep> selectByTemplateId(Long templateId);
}
