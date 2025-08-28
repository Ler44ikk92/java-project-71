package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

public class App{
        // this example implements Callable, so parsing, error handling and handling user
        // requests for usage help or version help can be done with one line of code.
        public static void main(String... args) {
           // int exitCode = new CommandLine(new CheckSum()).execute(args);
            int exitCode = new CommandLine(new Differ()).execute(args);
            System.exit(exitCode);
        }
    }

