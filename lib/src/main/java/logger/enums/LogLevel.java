package logger.enums;

public enum LogLevel {
    DEBUG,
    INFO,
    WARNING,
    ERROR;

    public boolean isEqualOrHigherThan(LogLevel level) {
        return this.ordinal() >= level.ordinal();
    }
}