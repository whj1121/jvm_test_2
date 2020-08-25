package com.wuhj.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author wuhaojie
 * @ClassName TestCountDownLatch
 * @createTime 2020/8/19
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
