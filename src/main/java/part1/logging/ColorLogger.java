package part1.logging;

import com.diogonunes.jcolor.AnsiFormat;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;


public class ColorLogger implements Logger {
    @Override
    public void log(String msg, LogLevel lgLvl) {
        String statusStr = "[" + lgLvl + "]";
        AnsiFormat fInfo = new AnsiFormat(BLUE_BACK(), BRIGHT_WHITE_TEXT());
        AnsiFormat fWarning = new AnsiFormat(YELLOW_BACK(), BRIGHT_WHITE_TEXT());
        AnsiFormat fError = new AnsiFormat(RED_BACK(), BRIGHT_WHITE_TEXT());
        AnsiFormat fBlue = new AnsiFormat(BLUE_TEXT());
        AnsiFormat fYellow = new AnsiFormat(YELLOW_TEXT());
        AnsiFormat fRed = new AnsiFormat(RED_TEXT());
        switch (lgLvl) {
            case LogLevel.INFO:
                System.out.println(formatMessage(colorize(statusStr, fInfo), colorize(msg, fBlue)));
            case LogLevel.WARNING:
                System.out.println(formatMessage(colorize(statusStr, fWarning), colorize(msg, fYellow)));
            case LogLevel.ERROR:
                System.out.println(formatMessage(colorize(statusStr, fError), colorize(msg, fRed)));
        }
    }
}
