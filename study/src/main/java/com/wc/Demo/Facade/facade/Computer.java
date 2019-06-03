package com.wc.Demo.Facade.facade;

import com.wc.Demo.Facade.children.CPU;
import com.wc.Demo.Facade.children.Disk;
import com.wc.Demo.Facade.children.Memory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Computer {

    public static final Logger LOGGER = LogManager.getLogger(Computer.class);

    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        cpu = new CPU();
        disk = new Disk();
        memory = new Memory();
    }

    public void start() {
        LOGGER.info("computer start begin...");
        cpu.start();
        disk.start();
        memory.start();
        LOGGER.info("computer start end...");
    }

    public void shutDown() {
        LOGGER.info("computer shutdown begin...");
        cpu.shutdown();
        disk.shutdown();
        memory.shutdown();
        LOGGER.info("computer shutdown end...");
    }
}
