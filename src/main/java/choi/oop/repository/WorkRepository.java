package choi.oop.repository;

import choi.oop.model.Work;
import choi.oop.repository.mapper.WorkMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class WorkRepository {
    private final WorkMapper mapper;
    public void insert(Work work) {
        mapper.insert(work);
    };
}
