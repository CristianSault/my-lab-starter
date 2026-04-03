package part1.logging;

public class InDenialLogger implements Logger {
    String[] inDenialStrs = {"Something went wrong 😭", "Pls help... Idk what's wrong 😵‍💫", "Nope",
            "Nuh-uh", "You expected it to work properly didn't you?", "Too bad", "Not gonna do it",
            "I don't think so", "Better luck next time!", "❌"};

    @Override
    public void log(String msg, LogLevel lgLvl) {
        if (!lgLvl.equals(LogLevel.ERROR)) {
            System.out.println(formatMessage(msg, lgLvl));
        } else {
            System.out.println(inDenialStrs[(int)(Math.random()*inDenialStrs.length)]);
        }
    }
}
