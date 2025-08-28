package hexlet.code;


import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Compares two configuration files and shows a difference.")

public class Differ implements Runnable{

    @CommandLine.Parameters(index = "0", paramLabel="filepath1", description = "path to first file")
    private File filepath1;
    @CommandLine.Parameters(index = "1", paramLabel="filepath2", description = "path to second file")
    private File filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, paramLabel="format", description = "output format [default: stylish]")
    private String format1;

    public static void generate(){

    }

    @Override
    public void run() {

    }
}
