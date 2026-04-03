package part1;

import part1.logging.*;
import part1.logging.LogLevel;
import part1.util.Messages;

import java.io.FileOutputStream;
import java.io.OutputStream;

import static java.lang.IO.println;

public class Main {

    static void main() {

        try {

            /* === Easy loggers === */
//            Logger logger = new ColorLogger();
//            Logger logger = new InDenialLogger();
//            Logger logger = new LoudLogger();

            /* === Medium loggers === */
//            Logger logger = new CensoriousLogger(List.of("hungrish", "drabblex", "clorphed", "snorvish", "grumblet", "flonky", "blarfish", "twindleful", "snibbetty", "glorped", "plobbly"));
//            Logger logger = new MultiLogger(List.of(new ConsoleLogger(), new StreamLogger(new FileOutputStream("log.txt"))));
//            Logger logger = new StreamLogger(System.out);                      // Using System.out as the destination
//            Logger logger = new StreamLogger(new FileOutputStream("log.txt")); // Using a file as the destination

            MemoryLogger logger = new MemoryLogger();

//            Logger logger = new JdbcLogger("jdbc:sqlite:log.db");

//            run(new ConsoleLogger(), 50);
            run(logger, 50);

            export(logger, new FileOutputStream("logs.txt"));  // OR try System.out as the second parameter!

        } catch (Exception e) {
            println("Could not create log file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void run(Logger logger, int n) {
        for ( int i = 0; i < n; i++ ) {
            var randomLevel = LogLevel.values()[(int) (Math.random() * LogLevel.values().length)];
            var message = Messages.getRandomMessage();
            logger.log(message, randomLevel);
        }
    }

    public static void export(Exportable exporter, OutputStream stream) {
        exporter.exportTo(stream);
    }
}
