package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
@AllArgsConstructor
@Getter
abstract class Tag {
    private String name;
    private Map<String, String> attributes;

    protected String buildAttributes() {
        return " " + this.attributes.entrySet().stream()
                .map(entry -> String.format("%s=\"%s\"", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" "));
    }

    @Override
    abstract public String toString();
}
// END
