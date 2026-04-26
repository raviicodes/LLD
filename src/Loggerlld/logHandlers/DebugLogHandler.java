package Loggerlld.logHandlers;

import Loggerlld.LogLevel;
import Loggerlld.strategy.ConsoleAppendingStrategy;

import java.util.List;

public class DebugLogHandler extends LogHandler {
    public DebugLogHandler() {
        super(new InfoLogHandler(), LogLevel.DEBUG, List.of(new ConsoleAppendingStrategy()));
    }
}
