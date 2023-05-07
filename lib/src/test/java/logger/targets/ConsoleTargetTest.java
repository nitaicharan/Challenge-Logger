package logger.targets;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import logger.enums.LogLevel;

public class ConsoleTargetTest {

    @Test
    @DisplayName("Should return true in case of higher value performed")
    public void perform_shouldPrintMessageAndReturnTrue_whenLogLevelIsEqualOrHigher() {
        var consoleTarget = new ConsoleTarget(LogLevel.WARNING);
        boolean result = consoleTarget.perform(LogLevel.ERROR, Mockito.anyString());

        assertTrue(result);
    }
}
