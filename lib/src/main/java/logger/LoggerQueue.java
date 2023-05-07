package logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import logger.enums.LogLevel;

public class LoggerQueue implements PropertyChangeListener {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    final Queue<Map.Entry<LogLevel, String>> queue = new ConcurrentLinkedQueue<>();

    public LoggerQueue() {
        pcs.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
    }

    public void addToQueu(LogLevel level, String message) {
        queue.add(Map.entry(level, message));
    }
}
