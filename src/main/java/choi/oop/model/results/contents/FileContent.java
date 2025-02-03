package choi.oop.model.results.contents;

import choi.oop.model.support.FileType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FileContent extends ResultContent {
    private Long fileId;
    private FileType type;

    public FileContent(long fileId, FileType type) {
        this.fileId = fileId;
        this.type = type;
    }
}
