package sk.stuba.fei.movenexample;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;

import java.text.ParseException;

public class Main {
    private static CommandLineParser parser = new BasicParser();
    private static Options options = new Options();
    public static void main(String[] args) throws org.apache.commons.cli.ParseException {
        try {
            parseArgumentValue(args);
        } catch (ParseException e) {
            printParseException(e);
        }
    }
    
    private static void parseArgumentValue(String[] args) throws
            ParseException, org.apache.commons.cli.ParseException {
        CommandLine commandLine = parseCommands(args);
        System.out.println("a=" + commandLine.getOptionValue("a"));
    }

    private static CommandLine parseCommands(String[] args) throws
            ParseException, org.apache.commons.cli.ParseException {
        options.addOption("a", true, "an argument");
        return parser.parse(options, args);
    }

    private static void printParseException(ParseException e) {
        System.out.println(e.getMessage());
        System.out.println("Usage: java -jar -a <value>");
    }
}
