package Loggerlld;

import java.time.Instant;

public class LoggerMessage {
     private String message;
     private LogLevel logLevel;
     private Instant timeStamp;

    public LoggerMessage(String message, LogLevel logLevel, Instant timeStamp) {
        this.message = message;
        this.logLevel = logLevel;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }
}
