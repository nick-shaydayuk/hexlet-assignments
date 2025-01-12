package exercise;

import lombok.AllArgsConstructor;

import java.util.Map;

// BEGIN

class SingleTag extends Tag{
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    public String toString() {
        return String.format("<%s%s>", this.getName(), this.getAttributes().isEmpty() ? "" : this.buildAttributes());
    }
}
// END
