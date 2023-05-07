package logger.interfaces;

import logger.enums.LogLevel;

public interface ITarget {
    boolean perform(LogLevel level, String message);
}
