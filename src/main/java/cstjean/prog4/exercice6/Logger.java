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
        if (loggers.isEmpty()) {
            System.out.println("Aucuns loggers trouvés");
            return;
        }

        for (LoggerBase logger : loggers) {
            if ((logger.getMask() & level) != 0) {
                logger.log(message);
            }
        }
    }
    public void addLogger(LoggerBase logger) {
        loggers.add(logger);
    }
}
