package com.wuhj.ram;

/**
 * @author wuhaojie
 * @ClassName Test2
 * @createTime 2020/5/28
 */
public class Test2 {


    public static void main(String[] args) {

        new String("asd");

        final ThreadTest threadTest = new ThreadTest();

        new Thread() {
            @Override
            public void run() {
                threadTest.method1();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                threadTest.method2();
            }
        }.start();
    }
}

class ThreadTest {
    private Test2 test = new Test2();
    private Test2 test2 = new Test2();
    public void method1() {
        synchronized (test) {
            System.out.println("wait test2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (test2) {
                System.out.println("get test2");
            }
        }
    }
    public void method2() {
        synchronized (test2) {
            System.out.println("wait test");
            synchronized (test) {
                System.out.println("get test");
            }
        }
    }
}
