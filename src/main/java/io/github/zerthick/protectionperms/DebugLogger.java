package io.github.zerthick.protectionperms;

import org.slf4j.Logger;

/**
 * Created by Chase on 11/26/2016.
 */
public class DebugLogger {

    private static DebugLogger ourInstance = new DebugLogger();
    private Logger logger;

    private DebugLogger() {
    }

    public static DebugLogger getInstance() {
        return ourInstance;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
