package Loggerlld.strategy;

import Loggerlld.LoggerMessage;

public class ConsoleAppendingStrategy  implements AppendingStrategy{
    @Override
    public void append(LoggerMessage loggerMessage) {
         System.out.println("["+loggerMessage.getLogLevel()+"]: "+loggerMessage.getTimeStamp()+" "+loggerMessage.getMessage()+" appended on console");
    }
}
