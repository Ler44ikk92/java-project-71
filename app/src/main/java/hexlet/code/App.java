package hexlet.code;

import picocli.CommandLine;

import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.Callable;
@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", paramLabel="filepath1", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1", paramLabel="filepath2", description = "path to second file")
    private String filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, paramLabel="format", description = "output format [default: stylish]")
    private String format1;

    @Override
    public Integer call() throws Exception {
//        String content = (Differ.getData(String.valueOf(filepath1)));
//        String content2 = (Differ.getData(String.valueOf(filepath2)));
//        Map<String, Object> pars1 = Parser.parser(content);
//        Map<String, Object> pars2 = Parser.parser(content2);
        System.out.println(Differ.generate(filepath1, filepath2));
        //System.out.println(Parser.parser(content2));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    }

