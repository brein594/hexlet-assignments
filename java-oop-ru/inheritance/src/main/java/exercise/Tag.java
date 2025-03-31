package exercise;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
//import lombok.Getter;
// BEGIN
//@Getter
public class Tag{
    private String nameTag;
    private LinkedHashMap<String, String> attribute;

    public Tag(String nameTag, Map<String, String> attribute) {
        this.nameTag = nameTag;
        this.attribute = new LinkedHashMap<>();
        var keys = attribute.keySet();
        for (var key : keys) {
            this.attribute.put(key, attribute.get(key));
        }
    }

    //public abstract String toString();

    public String getNameTag(){
        return nameTag;
    }

    public Map<String, String> getAttribute() {
        LinkedHashMap<String, String> newMap = new LinkedHashMap<>();
        var keys = attribute.keySet();
        for (var key : keys) {
            newMap.put(key, attribute.get(key));
        }
        return newMap;
    }

    public String toString(){
        return String.format("<%s%s>", getNameTag(), mapToString(getAttribute()));
    }

    private static String mapToString(Map<String, String> attribute){
        StringBuilder result = new StringBuilder();
        for (var key : attribute.keySet()) {
            result.append(" " + key + "=\"" + attribute.get(key) + "\"");
        }
        return result.toString();
    }
}
// END
