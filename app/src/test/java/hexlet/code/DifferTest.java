package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private final String filepath1 = "src/test/resources/file1.json";
    private final String filepath2 = "src/test/resources/file2.json";
    private String expected =
            "{- follow=false, - proxy=123.234.53.22,   host=hexlet.io, - timeout=50, + timeout=20, + verbose=true}";

    @Test
    void testDiffer() throws Exception {
        String actual = Differ.generate(filepath1, filepath2);
        assertEquals(expected, actual);
    }
}
