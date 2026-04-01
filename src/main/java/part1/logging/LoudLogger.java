package part1.logging;

public class LoudLogger implements Logger {
    @Override
    public void log(String msg, LogLevel lgLvl) {
        System.out.println(formatMessage(msg.toUpperCase().replace(".", "!!!"), lgLvl));
    }
}
