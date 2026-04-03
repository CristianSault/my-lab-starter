package part1.logging;

import java.util.List;

public class CensoriousLogger implements Logger {
    private final List<String> censoredWords;

    public CensoriousLogger(List<String> hungrish) {
        censoredWords = hungrish;
    }

    @Override
    public void log(String msg, LogLevel lgLvl) {
        for (String censoredWord : censoredWords) {
            // Censor whatever word it found in the message
            if (msg.contains(censoredWord)) {
                msg = msg.replace(censoredWord, "*".repeat(censoredWord.length()));
                System.out.println(formatMessage(msg, lgLvl));
                return;
            }
        }
//        if (msg.lines().anyMatch(msg::contains)){
//            msg = msg.replace(censoredWords.get(?)?, "*".repeat(censoredWord?.length())); idk what to do here...
//            formatMessage(msg, lgLvl);
//        }
        // Normal case, no need to censor anything
        System.out.println(formatMessage(msg, lgLvl));
    }
}
