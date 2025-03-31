package exercise;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String text;
    private List<Tag> tags;

    public PairedTag(String nameTag, Map<String, String> attribute, String text, List<Tag> tags) {
        super(nameTag, attribute);
        this.text = text;
        this.tags = new ArrayList<>(tags);
    }

    public String toString() {
        return String.format("<%s%s>%s%s</%s>", getNameTag(), mapToString(getAttribute()),
                listToString(this.tags), this.text, getNameTag());
    }

    private static String mapToString(Map<String, String> attribute) {
        StringBuilder result = new StringBuilder();
        for (var key : attribute.keySet()) {
            result.append(" " + key + "=\"" + attribute.get(key) + "\"");
        }
        return result.toString();
    }

    private static String listToString(List<Tag> listTags) {
        StringBuilder result = new StringBuilder();
        for (var tag : listTags) {
            result.append(tag.toString());
        }
        return result.toString();
    }

}
// END
