package Loggerlld.strategy;

import Loggerlld.LoggerMessage;

public class FileAppender implements AppendingStrategy{
    @Override
    public void append(LoggerMessage loggerMessage) {
        System.out.println("["+loggerMessage.getLogLevel()+"]: "+loggerMessage.getTimeStamp()+" "+loggerMessage.getMessage()+" appended in file");
    }
}
