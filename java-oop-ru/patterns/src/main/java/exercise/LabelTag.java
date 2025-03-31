package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface labelTag;
    String labelText;

    public LabelTag(String labelText, TagInterface labelTag) {
        this.labelText = labelText;
        this.labelTag = labelTag;
    }

    public String render() {
        StringBuilder text = new StringBuilder("<label>");
        text.append(labelText);
        text.append(labelTag.render());
        text.append("</label>");
        return text.toString();
    }
}
// END
