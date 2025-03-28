package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
final class InMemoryKV implements KeyValueStorage {
    private HashMap<String, String> map;

    public InMemoryKV(Map<String, String> originalMap) {
        map = new HashMap<>();
        var entries = originalMap.entrySet();
        for (var entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        HashMap<String, String> newMap = new HashMap<>();
        var entries = map.entrySet();
        for (var entry : entries) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        return newMap;
    }
}
// END
