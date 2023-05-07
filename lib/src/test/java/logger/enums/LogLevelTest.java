package logger.enums;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogLevelTest {

    @Test
    @DisplayName("Should return true in case lower level is compared")
    public void checkIfValuePassedIsLower() {
        var errorLevel = LogLevel.ERROR;
        var warnLevel = LogLevel.WARNING;
        boolean result = errorLevel.isEqualOrHigherThan(warnLevel);

        assertTrue(result);
    }

    @Test
    @DisplayName("Should return true in case equal level is compared")
    public void checkIfValuePassedIsEqual() {
        var errorLevel1 = LogLevel.ERROR;
        var errorLevel2 = LogLevel.ERROR;
        boolean result = errorLevel1.isEqualOrHigherThan(errorLevel2);

        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false in case lower level is compared")
    public void checkIfValuePassedIsHigher() {
        var debugLevel = LogLevel.DEBUG;
        var infoLevel = LogLevel.INFO;
        boolean result = debugLevel.isEqualOrHigherThan(infoLevel);

        assertFalse(result);
    }
}