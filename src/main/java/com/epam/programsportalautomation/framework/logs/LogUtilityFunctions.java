package com.epam.programsportalautomation.framework.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtilityFunctions {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void logInfoMessage(String message){
        LOGGER.info(message);
    }

    public static void logInfoError(String message){
        LOGGER.error(message);
    }
}
