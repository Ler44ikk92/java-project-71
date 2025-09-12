package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTest {
    private final String filepath1 = "src/test/resources/file1.json";
    private final String filepath2 = "src/test/resources/file2.json";
    private String expected =
            "{- follow=false, - proxy=123.234.53.22,   host=hexlet.io, - timeout=50, + timeout=20, + verbose=true}";
    private String expected2 = "{follow=false, timeout=50, proxy=123.234.53.22, host=hexlet.io}";

    @Test
    void testCompare() throws Exception {
        String content1 = Differ.getData(filepath1);
        String content2 =  Differ.getData(filepath2);

        Map<String, Object> map1 = Parser.parser(content1);
        Map<String, Object> map2 = Parser.parser(content2);
        Map<String, Object> actual = Compare.compare(map1, map2);
        assertEquals(expected, actual.toString());
    }

    @Test
    void testSortMap() throws Exception {
        String content1 = Differ.getData(filepath1);
        Map<String, Object> map1 = Parser.parser(content1);
        Map<String, Object> actual = Compare.sortMap(map1);
        assertEquals(expected2, actual.toString());
    }
}
