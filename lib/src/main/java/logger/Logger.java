package logger;

import logger.enums.LogLevel;

public class Logger {
    public void log(LogLevel level, String message) {
        LoggerContext.INSTANCE.addEntry(level, message);
    }

    public void debug(String message) {
        this.log(LogLevel.DEBUG, "[DEBUG] " + message);
    }

    public void info(String message) {
        this.log(LogLevel.INFO, "[INFO] " + message);
    }

    public void warn(String message) {
        this.log(LogLevel.WARNING, "[WARN] " + message);
    }

    public void error(String message) {
        this.log(LogLevel.ERROR, "[ERROR] " + message);
    }
}
