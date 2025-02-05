package choi.oop.repository.mapper.mybatis;

import choi.oop.model.templates.Template;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TemplateMapper {
    void insert(Template template);
    Template select(Long id);
}
