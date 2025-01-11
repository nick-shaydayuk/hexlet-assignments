package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var copy = storage.toMap();
        copy.forEach(((s, s2) -> {
            storage.unset(s);
            storage.set(s2, s);
        }));
    }
}
// END
