package cstjean.prog4.exercice6;

import java.util.ArrayList;

public class Logger {
    private ArrayList<LoggerBase> loggers;
    public static int NONE = 0;
    public static int INFO = 1;
    public static int WARNING = 2;
    public static int ERROR = 4;

    public Logger() {
        loggers = new ArrayList<LoggerBase>();
    }
    public void log(String message, int level) {
        if (loggers.size() == 0) {
            System.out.println("Aucuns loggers trouvés");
            return;
        }
        String binaryLevel = Integer.toBinaryString(level);
        for (int i = 0; i < loggers.size(); i++) {
            LoggerBase logger = loggers.get(i);
            if (logger.getBinaryMask().contains(binaryLevel)) {
                logger.log(message);
            }
        }
    }
    public void addLogger(LoggerBase logger) {
        loggers.add(logger);
    }
}
