package main.java.com.simra.app.csvimporter;

import main.java.com.simra.app.csvimporter.handler.ProfileDirectoryIOHandler;
import main.java.com.simra.app.csvimporter.handler.RideDirectoryIOHandler;
import main.java.com.simra.app.csvimporter.services.ConfigService;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.nio.file.Path;
import java.nio.file.Paths;


public class CSVImporter {

    private static Float DEFAULT_COORDINATE_MIN_ACCURACY = 20f;
    private static Double DEFAULT_RDP_EPSILON = 0.0000001;
    private static ConfigService config;

    public static void main(String[] args) throws ArgumentParserException {

        config = new ConfigService();
        ConfigService.readProperties();


        ArgumentParser parser = ArgumentParsers.newFor("CSVImporter").build()
                .defaultHelp(true)
                .description("Import CSV directory.");
        parser.addArgument("-t", "--type")
                .choices("r", "p").setDefault("r")
                .help("Specify file type r <- ride, p <- profile");
        parser.addArgument("dir")
                .help("Directory to read");
        parser.addArgument("-a", "--accuracy")
                .help("Minimum accuracy of to be processed coordinates").setDefault(DEFAULT_COORDINATE_MIN_ACCURACY).type(Float.class);
        parser.addArgument("-e", "--epsilon")
                .help("Epsilon Parameter of RDP-Algorithm").setDefault(DEFAULT_RDP_EPSILON).type(Double.class);
        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }
        String type = ns.getString("type");
        if (type.isEmpty()) throw new ArgumentParserException(parser);

        String dirName = ns.getString("dir");
        Path path = Paths.get(dirName);
        if (type.contains("p")) {
            new ProfileDirectoryIOHandler(path);
        } else if (type.contains("r")) {
            Float minAccuracy = ns.getFloat("accuracy");
            Double rdpEpsilon = ns.getDouble("epsilon");
            new RideDirectoryIOHandler(path, minAccuracy, rdpEpsilon);
        }
    }
}
