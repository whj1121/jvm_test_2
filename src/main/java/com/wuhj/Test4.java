package com.wuhj;

/**
 * @author wuhaojie
 * @ClassName Test4
 * @createTime 2020/4/21
 */
public class Test4 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(Singleton.a);
        System.out.println(Singleton.b);

    }
}

class Singleton {


    public static int a;
    private static Singleton singleton = new Singleton();
    public Singleton() {
        a++;
        b++;

    }

    public  static int b = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}