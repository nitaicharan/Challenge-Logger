package logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import logger.enums.LogLevel;
import logger.interfaces.ITarget;

public class LoggerContext implements PropertyChangeListener {
    static final LoggerContext INSTANCE = new LoggerContext();
    private final List<ITarget> targets = new ArrayList<>();
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private LoggerContext() {
        propertyChangeSupport.addPropertyChangeListener(this);
    }

    public static void setTargets(ITarget... targets) {
        if (targets.length == 0) {
            return;
        }

        Collections.addAll(INSTANCE.targets, targets);
    }

    public void addEntry(LogLevel level, String message) {
        propertyChangeSupport.firePropertyChange("new entry", null, Map.entry(level, message));
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        var name = event.getPropertyName();
        var notValid = !"new entry".equals(name);
        if (notValid) {
            return;
        }

        Map.Entry<LogLevel, String> entry = (Map.Entry<LogLevel, String>) event.getNewValue();
        for (ITarget target : targets) {
            performIntoNewThread(() -> target.perform(entry.getKey(), entry.getValue()));
        }
    }

    private void performIntoNewThread(Runnable function) {
        var thread = new Thread(function);
        thread.start();
    }
}
