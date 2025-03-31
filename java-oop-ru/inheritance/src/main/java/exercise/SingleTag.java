package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String nameTag, Map<String, String> attribute) {
        super(nameTag, attribute);
    }

    @Override
    public String toString() {
        return String.format("<%s%s>", getNameTag(), mapToString(getAttribute()));
    }

    private static String mapToString(Map<String, String> attribute) {
        StringBuilder result = new StringBuilder();
        for (var key : attribute.keySet()) {
            result.append(" " + key + "=\"" + attribute.get(key) + "\"");
        }
        return result.toString();
    }
}
// END
