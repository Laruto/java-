package com.wc.Demo.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AB_lock {

    private static Lock lock= new ReentrantLock();
    private static boolean flag = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 10;) {
                    try {
                        lock.lock();
                        while (flag) {
                            System.out.println("A");
                            flag = false;
                            i++;
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 10;) {
                    try {
                        lock.lock();
                        while (!flag) {
                            System.out.println("B");
                            flag = true;
                            i++;
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
