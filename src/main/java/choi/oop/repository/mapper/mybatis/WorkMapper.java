package choi.oop.repository.mapper.mybatis;

import choi.oop.model.Work;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkMapper {
    void insert(Work work);
}
