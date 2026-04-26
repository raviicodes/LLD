package Loggerlld.logHandlers;

import Loggerlld.LogLevel;
import Loggerlld.strategy.ConsoleAppendingStrategy;
import Loggerlld.strategy.DBAppender;
import Loggerlld.strategy.FileAppender;

import java.util.List;

public class InfoLogHandler extends LogHandler {
    public InfoLogHandler() {
        super(new ErrorLogHandler(), LogLevel.INFO, List.of(new FileAppender(),new DBAppender(),new ConsoleAppendingStrategy()));
    }
}
