package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    private final String filepath = "src/test/resources/file2.json";
    private final int n1 = 20;

    @Test
    void testParser() throws Exception {
        Map<String, Object> actual = Parser.parser(Differ.getData(filepath));
        Map<String, Object> expected = new HashMap<>();
        expected.put("timeout", n1);
        expected.put("verbose", true);
        expected.put("host", "hexlet.io");
        assertEquals(expected, actual);
    }
}
