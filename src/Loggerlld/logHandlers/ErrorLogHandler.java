package Loggerlld.logHandlers;

import Loggerlld.LogLevel;
import Loggerlld.strategy.ConsoleAppendingStrategy;

import java.util.List;

public class ErrorLogHandler extends LogHandler {
    public ErrorLogHandler() {
        super(null, LogLevel.ERROR, List.of(new ConsoleAppendingStrategy()));
    }
}
