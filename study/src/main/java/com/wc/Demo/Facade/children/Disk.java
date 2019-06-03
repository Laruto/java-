package com.wc.Demo.Facade.children;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Disk {

    public static final Logger LOGGER = LogManager.getLogger(Disk.class);

    public void start() {
        LOGGER.info("disk is start...");
    }

    public void shutdown() {
        LOGGER.info("disk is shutdown...");
    }
}
