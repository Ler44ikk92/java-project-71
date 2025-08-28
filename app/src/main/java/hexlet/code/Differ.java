package hexlet.code;


import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Compares two configuration files and shows a difference.")

public class Differ implements Runnable{

    public static void generate(){

    }

    @Override
    public void run() {

    }
}
