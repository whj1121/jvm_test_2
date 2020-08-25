package com.wuhj.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuhaojie
 * @ClassName TestCondition
 * @createTime 2020/8/14
 */
public class TestCondition {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();


        Thread thread = new Thread(() -> {
            lock.lock();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "get lock");
            try {
                System.out.println(Thread.currentThread().getName() + "await");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "  被唤醒了" + Thread.currentThread().isInterrupted());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + thread.isInterrupted());
            condition.signal();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            thread.interrupt();

            System.out.println(Thread.currentThread().getName() + thread.isInterrupted());
            System.out.println("唤醒");
            lock.unlock();
        });
        thread1.start();
       /* try {

            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("12312312321313123213");
//        lock.lock();
  //      condition.signalAll();
        System.out.println("signall");
    }
}


