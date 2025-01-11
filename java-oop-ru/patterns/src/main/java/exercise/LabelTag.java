package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
public class LabelTag implements TagInterface {
    private String text;
    private TagInterface child;

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", this.text, this.child.render());
    }
}
// END
