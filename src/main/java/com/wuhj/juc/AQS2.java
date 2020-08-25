package com.wuhj.juc;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuhaojie
 * @ClassName AQS2
 * @createTime 2020/8/17
 */
public class AQS2 {

    public static void main(String[] args) {
        /*ReentrantLock lock = new ReentrantLock();

        lock.lock();*/
        Thread thread = new Thread((() -> {
            /*for (int i = 0; i < 300000; i++) {

                System.out.println("aaa");
            }*/
            System.out.println("aaa");
           /* try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }));
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        LockSupport.park(thread);
        System.out.println(thread.isInterrupted());
        new Thread(() -> {
            thread.interrupt();
        }).start();
    }
}
