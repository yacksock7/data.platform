package choi.oop.model.results.contents;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextContent extends ResultContent {
    private String text;

    public TextContent(String text) {
        this.text = text;
    }
}
