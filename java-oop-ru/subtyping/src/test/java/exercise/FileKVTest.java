package exercise;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void kvTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        //assertThat(storage.get("key2", "default")).isEqualTo("default");
        assertThat(storage.get("key", "default")).isEqualTo("value");
        assertThat(storage.get("key2", "default")).isEqualTo("default");
        storage.set("key2", "value2");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");
        storage.unset("key");
        assertThat(storage.get("key", "def")).isEqualTo("def");
    }

    @Test
    void mustBeImmutableKvTest() {
        Map<String, String> initial = new HashMap<>();
        initial.put("key", "value");

        Map<String, String> clonedInitial = new HashMap<>();
        clonedInitial.putAll(initial);

        KeyValueStorage st = new FileKV("src/test/resources/file", initial);
        initial.put("key2", "value2");
        assertThat(st.toMap()).isEqualTo(clonedInitial);

        Map<String, String> map = st.toMap();
        map.put("key2", "value2");
        assertThat(st.toMap()).isEqualTo(clonedInitial);
    }


    // END
}
