package com.wuhj.classLoder;

/**
 * @author wuhaojie
 * @ClassName Test1
 * @createTime 2020/4/18
 */
public class Test1 {


    public static void main(String[] args) {
        System.out.println(A.str);
    }

}

class A {
    public static final String str = "hello world";

    static {
        System.out.println("A static 代码块");
    }

}
