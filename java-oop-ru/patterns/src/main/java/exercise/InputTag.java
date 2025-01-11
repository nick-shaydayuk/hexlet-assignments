package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
public class InputTag implements TagInterface {
    private String type;
    private String value;

    @Override
    public String render() {
        return String.format("<input type=\"%s\" value=\"%s\">", this.type, this.value);
    }
}
// END
