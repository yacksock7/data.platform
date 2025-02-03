package choi.oop.model.results.contents;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TagContent extends ResultContent {
    private Integer startIndex;
    private Integer endIndex;
    private String tag;

    public TagContent(Integer startIndex, Integer endIndex, String tag) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.tag = tag;
    }
}
