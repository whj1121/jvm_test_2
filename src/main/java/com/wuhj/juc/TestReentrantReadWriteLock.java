package com.wuhj.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wuhaojie
 * @ClassName TestReentrantReadWriteLock
 * @createTime 2020/8/19
 */
public class TestReentrantReadWriteLock {


    public static void main(String[] args) {
        //测试锁降级
        //lockDowngrade();

        //testReadReentrant();

        //testAQSReadLock();

        test();
    }

    private static void lockDowngrade() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);


        new Thread(() -> {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " get write lock");
            reentrantReadWriteLock.readLock().lock();


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantReadWriteLock.writeLock().unlock();
            reentrantReadWriteLock.readLock().unlock();
        }).start();
        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock");
        }).start();

        new Thread(() -> {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " get write lock");
        }).start();


        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock");
        }).start();
    }


    public static void testReadReentrant() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Runnable runnable = () -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock  1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantReadWriteLock.readLock().unlock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock  2");


        }).start();
    }


    public static void testAQSReadLock() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Runnable runnable = () -> {
            reentrantReadWriteLock.readLock().lock();
        };


        Thread thread = new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock 1");
        });

        thread.start();

        new Thread(() -> {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " get write lock");
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock 1");
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock 2");
        }).start();
    }


    public static void test() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        new Thread(() -> {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " get write lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                reentrantReadWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " get read lock");
            }).start();

            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock");
            reentrantReadWriteLock.writeLock().unlock();
        }).start();
    }
}
