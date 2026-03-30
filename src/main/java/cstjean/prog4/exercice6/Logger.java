package cstjean.prog4.exercice6;

import java.util.ArrayList;

public abstract class Logger {
    private ArrayList<Logger> loggers;
    public static int NONE = 0;
    public static int INFO = 1;
    public static int WARNING = 2;
    public static int ERROR = 4;

    public Logger() {
        loggers = new ArrayList<Logger>();
    }
    public void log(String message, int level) {
        if (loggers.size() == 0) {
            System.out.println("Aucuns loggers trouvés");
            return;
        }
        for (int i = 0; i < loggers.size(); i++) {
            loggers.get(i).log(message, level);
        }
    }
    public void addLogger(Logger logger) {
        loggers.add(logger);
    }
}
