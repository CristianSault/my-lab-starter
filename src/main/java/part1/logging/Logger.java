package part1.logging;

import java.time.Clock;
import java.time.Instant;

/**
 * Main interface for the lab
 */
public interface Logger {
    /**
     * Main implementable method for all derived loggers.
     * @param msg a String representation of the message for the logger
     * @param lgLvl how important the message is for the logger
     */
    void log(String msg, LogLevel lgLvl);

    /**
     * Main default method for the `log` method.
     * @param msg a String representation of the message for the logger
     * @param lgLvl how important the message is for the logger
     * @return a formatted String
     */
    default String formatMessage(String msg, LogLevel lgLvl) {
        return (Instant.now(Clock.systemDefaultZone()) + " [" + lgLvl + "] " + msg);
    }

    /** for ColorLogger specifically
     *
     * @param lgLvl already formatted with the correct AnsiFormat
     * @param msg already formatted with the correct AnsiFormat
     */
    default String formatMessage(String lgLvl, String msg) {
        return (Instant.now(Clock.systemDefaultZone()) + " " + lgLvl + " " + msg);
    }
}