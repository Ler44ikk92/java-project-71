package hexlet.code;


import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Differ implements Runnable{




    public static String generate(String filepath1, String filepath2) throws Exception {
        String readFilePath1 = "./src/test/resources/" + filepath1;
        String readFilePath2 = "./src/test/resources/" + filepath2;
        String str = Differ.getData(readFilePath1);
        return str;
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

    }
}
