package choi.oop.repository.mapper;

import choi.oop.model.results.contents.FileContent;

public interface FileContentMapper {

    void insert(FileContent content);

    FileContent select(Long resultId);

    void update(FileContent content);

    void delete(Long resultId);
}
