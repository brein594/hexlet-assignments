package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {


    public static void swapKeyValue(KeyValueStorage storage) {
        KeyValueStorage result = new InMemoryKV(storage.toMap());
        var entries = storage.toMap().entrySet();
        for (var entry : entries) {
            storage.unset(entry.getKey());
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
