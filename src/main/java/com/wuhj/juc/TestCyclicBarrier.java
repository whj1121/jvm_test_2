package com.wuhj.juc;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wuhaojie
 * @ClassName TestCyclicBarrier
 * @createTime 2020/8/17
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("asdads");
        });

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start await");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " start end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " BrokenBarrierException end");
            }
        });
        thread.start();

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start await");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " start end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " BrokenBarrierException end");
            }
        });
        thread3.start();

/*        Thread thread2 = new Thread(() -> {

            try {
                cyclicBarrier.reset();
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " start await");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " start end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " BrokenBarrierException end");
            }
        });
        thread2.start();*/

       // thread.interrupt();
    }
}
