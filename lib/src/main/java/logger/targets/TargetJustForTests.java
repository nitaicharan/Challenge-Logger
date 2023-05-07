package logger.targets;

import logger.enums.LogLevel;
import logger.interfaces.ITarget;

public abstract class TargetJustForTests implements ITarget {
    private final LogLevel level;

    protected TargetJustForTests(LogLevel level) {
        this.level = level;
    }

    @Override
    public boolean perform(LogLevel level, String message) {
        var notValid = !level.isEqualOrHigherThan(this.level);
        if (notValid) {
            return false;
        }

        System.out.printf("%s [%s]%n", message, this.getClass().getName());
        return true;
    }
}