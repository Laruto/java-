package com.wc.Demo.Facade.children;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.logging.Level;

public class Memory {

    public static final Logger LOGGER = LogManager.getLogger(Memory.class);

    public void start() {
        LOGGER.info("memory is start...");
    }

    public void shutdown() {
        LOGGER.info("memory is shutdown...");
    }
}
