package com.wuhj.juc;

/**
 * @author wuhaojie
 * @ClassName Test
 * @createTime 2020/8/19
 */
public class Test {


    public static void main(String[] args) {
        BBB bbb = new BBB();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                bbb.getAaa();
            }).start();
        }
    }
}


class BBB {

    private static class AAA {

    }

    private AAA aaa = new AAA();

    public AAA getAaa() {
        return aaa;
    }
}
