package exercise;

import lombok.Getter;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
@Getter
class PairedTag extends Tag {

    private final List<Tag> children;
    private final String text;

    public PairedTag(String name, Map<String, String> attributes, String text, List<Tag> children) {
        super(name, attributes);
        this.text = text;
        this.children = children;
    }

    public String buildChildren() {
        return this.children.stream().map(Tag::toString).collect(Collectors.joining(""));
    }

    public String toString() {
        return String.format("<%s%s>%s%s</%s>", this.getName(), this.getAttributes().isEmpty() ? "" : this.buildAttributes(), this.getText(), this.buildChildren(), this.getName());
    }
}
// END
