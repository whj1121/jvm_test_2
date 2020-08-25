package com.wuhj.bytecode;

/**
 * @author wuhaojie
 * @ClassName ByteCodeTest2
 * @createTime 2020/5/18
 */
public class ByteCodeTest2 {

    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();
        ByteCodeTest2 test2 = new ByteCodeTest2();
        test2.test(g1);
        test2.test(g2);
    }

}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}