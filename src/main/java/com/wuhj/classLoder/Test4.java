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

/**
 * 执行Singleton instance = Singleton.getInstance();之后下面代码的执行逻辑
 * 当调用一个类的静态方法的时候，是对这个类的主动使用，主动使用会导致类的初始化
 *
 * 1 在类的准备阶段，会为静态变量设置默认值
 *  下面代码在准备阶段 a=0 singleton=null b=0
 * 2 在初始化阶段会按照代码顺序执行初始化代码(设置静态变量正确的初始值(手动指定的值),执行构造方法)
 *   a=0 执行构造方法 a=1 b=1，构造方法执行完之后，b的值又被显示的指定为0所以最后的情况是
 *   a=0 b=0 singleton=实例出来的对象
 *
 */
class Singleton {

    public static  int a;
    private static Singleton singleton = new Singleton();
    public Singleton() {
        a++;
        b++;
    }

    static {
        System.out.println("asdasdsad");
    }
    public  static int b = 0;

    public static Singleton getInstance() {
        System.out.println("123");
        //return singleton;
        return null;
    }
}