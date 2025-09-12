package hexlet.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DifferTest {

    private final String filepath1 = "src/test/resources/file1.json";
    private final String filepath2 = "src/test/resources/file2.json";
    private final String expected = Files.readString(Paths.get("src/test/resources/expected/file.json"));

    DifferTest() throws IOException {
    }

    @Test
    void testDiffer() throws Exception {
        String actual = Differ.generate(filepath1, filepath2);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node1 = objectMapper.readTree(actual);
        JsonNode node2 = objectMapper.readTree(expected);
        assertTrue(node1.equals(node2), "JSON объекты не равны");
    }
}
