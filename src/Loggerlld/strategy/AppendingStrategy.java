package Loggerlld.strategy;

import Loggerlld.LoggerMessage;

public interface AppendingStrategy {
    void append(LoggerMessage loggerMessage);
}
