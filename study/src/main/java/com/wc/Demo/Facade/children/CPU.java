package com.wc.Demo.Facade.children;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CPU {

    public static final Logger LOGGER = LogManager.getLogger(CPU.class);

    public void start() {
        LOGGER.info("cpu is start...");
    }

    public void shutdown() {
        LOGGER.info("cpu is shutdown...");
    }
}
