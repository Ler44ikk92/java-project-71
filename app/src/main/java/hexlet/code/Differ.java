package hexlet.code;




import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Differ implements Runnable {


    public static String generate(String filepath1, String filepath2) throws Exception {
        String content1 = Differ.getData(filepath1);
        String content2 =  Differ.getData(filepath2);

        Map<String, Object> map1 = Parser.parser(content1);
        Map<String, Object> map2 = Parser.parser(content2);
        return Parser.convertToJson(Compare.compare(map1, map2));
    }


    // метод parse может выбросить исключение, пробросим его выше
    public static String getData(String filepath) throws Exception {
        Path path = Paths.get(filepath);
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String content = Files.readString(path);
        return content;
    }


    @Override
    public void run() {
        //
    }
}
