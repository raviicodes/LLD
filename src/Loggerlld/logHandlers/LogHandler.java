package Loggerlld.logHandlers;

import Loggerlld.LogLevel;
import Loggerlld.LoggerMessage;
import Loggerlld.strategy.AppendingStrategy;

import java.util.List;

public abstract class LogHandler {
    private LogHandler nextLogHandler;
    private LogLevel logLevel;
    private List<AppendingStrategy> appendingStrategyList;

    public LogHandler(LogHandler nextLogHandler, LogLevel logLevel,List<AppendingStrategy>appendingStrategyList) {
        this.nextLogHandler = nextLogHandler;
        this.logLevel = logLevel;
         this.appendingStrategyList=appendingStrategyList;
    }
    public  boolean canLog(LoggerMessage loggerMessage){
         return loggerMessage.getLogLevel().equals(logLevel);
    };

    public  void log(LoggerMessage loggerMessage){

            if(canLog(loggerMessage)){
              append(loggerMessage);
            }
            else  if(nextLogHandler!=null){
                nextLogHandler.log(loggerMessage);
            }
            else {
                System.out.println("No log handler find with loglevel: "+loggerMessage.getLogLevel());
            }

    };
    public void append(LoggerMessage loggerMessage){
         for(AppendingStrategy appender:appendingStrategyList){
              appender.append(loggerMessage);
         }
    }
}
