package part1.logging;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MemoryLogger implements Logger, Exportable {
    private final List<String> storedMssgs;

    public MemoryLogger(){
        this.storedMssgs = new ArrayList<>();
    }

    @Override
    public void log(String msg, LogLevel lgLvl){
        storedMssgs.add(formatMessage(msg, lgLvl));
    }

    @Override
    public void exportTo(OutputStream out){
        PrintWriter pw = new PrintWriter(out);
        for (String msg : storedMssgs) {
            pw.append(msg);
            pw.append('\n');
        }
        pw.close();
    }
}