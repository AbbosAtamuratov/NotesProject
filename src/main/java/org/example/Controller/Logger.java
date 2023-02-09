package org.example.Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logs;
    private static Date date = new Date();
    private static SimpleDateFormat sDate = new SimpleDateFormat("HH:mm dd.MM.yyyy");
    private static final String sessionName = String.format("session %s", sDate.format(date.getTime()));
    private static String logData = String.format("Logs for %s...\n", sessionName);


    public Logger() {}

    public static synchronized Logger getLogger(){
        if (logs == null)
            logs = new Logger();
        return logs;
    }

    public void addLog(String inputInfo, String programResponse){
        logData += sDate.format(date.getTime()) + ": " + inputInfo + " - " + programResponse +"\n";
    }

    public void showLogs() { System.out.println(logData); }

    public void saveLogs(){
        String[] lines = logData.split("\n");
        try {
            FileWriter fw = new FileWriter(String.format("%s.txt", sessionName), false);
            for (String line: lines) {
                fw.write(line);
                fw.append('\n');
            }
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
