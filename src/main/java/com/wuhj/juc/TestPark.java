package com.wuhj.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author wuhaojie
 * @ClassName TestPark
 * @createTime 2020/7/23
 */
public class TestPark {

    public static void main(String[] args) {
/*
        Thread thread = new Thread(() -> {
            System.out.println("park start");
           // LockSupport.park();
            System.out.println("park end");
        });
        thread.start();*/
        //thread.interrupt();

        //System.out.println(Thread.interrupted());
/*        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());*/
        boolean a = false;

        System.out.println(a |= false);

        System.out.println(true && false);
        System.out.println(true || false);

    }
}
