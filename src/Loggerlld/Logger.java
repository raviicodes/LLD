package Loggerlld;

import Loggerlld.logHandlers.DebugLogHandler;
import Loggerlld.logHandlers.LogHandler;

import java.time.Instant;
public class Logger {
    private LogHandler logHandler;
    public Logger() {
        this.logHandler = new DebugLogHandler();
    }
    public  void log(LoggerMessage loggerMessage){
        logHandler.log(loggerMessage);
    }

    public void info(String message){
         LoggerMessage loggerMessage=new LoggerMessage(message,LogLevel.INFO, Instant.now());
         log(loggerMessage);
    }
    public void deubug(String message){
         LoggerMessage loggerMessage=new LoggerMessage(message,LogLevel.DEBUG,Instant.now());
         log(loggerMessage);
    }
    public void error(String message){
         LoggerMessage loggerMessage=new LoggerMessage(message,LogLevel.ERROR,Instant.now());
         log(loggerMessage);
    }

}
