package logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import logger.enums.LogLevel;
import logger.targets.ConsoleTarget;
import logger.targets.EmailTarget;
import logger.targets.FileSystemTarget;
import logger.targets.ServerApiTarget;

class LibraryTest {
    @Test
    @DisplayName("Should show log only warn and debug level")
    void testOnlyWarnAndError() {
        var console = new ConsoleTarget(LogLevel.DEBUG);
        var email = new EmailTarget(LogLevel.WARNING);
        var fileSystem = new FileSystemTarget(LogLevel.ERROR);
        var serverApi = new ServerApiTarget(LogLevel.INFO);
        LoggerContext.setTargets(console, email, fileSystem, serverApi);

        Logger logger = new Logger();
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warning message");
        logger.error("error message");
    }
}
