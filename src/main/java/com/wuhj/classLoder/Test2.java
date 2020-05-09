package com.wuhj.classLoder;

/**
 * @author wuhaojie
 * @ClassName Test2
 * @createTime 2020/4/18
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(child.str);
    }

}


class Parent {
    public static String str = "hello";

    static {
        System.out.println("parent static");
    }
}

class child extends Parent {
    public static String str2 = "hello";

    static {
        System.out.println("child static");
    }
}