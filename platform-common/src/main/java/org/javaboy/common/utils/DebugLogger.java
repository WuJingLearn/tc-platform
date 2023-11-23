package org.javaboy.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:majin.wj
 */
public class DebugLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugLogger.class);


    public static void info(String msg, Object... args) {
        LOGGER.info(msg, args);
    }

    public static void error(String msg, Throwable t) {
        LOGGER.error(msg, t);
    }

    public static void error(String msg) {
        LOGGER.error(msg);
    }

}
