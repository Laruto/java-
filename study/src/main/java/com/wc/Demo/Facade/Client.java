package com.wc.Demo.Facade;

import com.wc.Demo.Facade.facade.Computer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Client {

    public static final Logger LOGGER = LogManager.getLogger(Client.class);

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        LOGGER.info("=============");
        computer.shutDown();
    }
}
