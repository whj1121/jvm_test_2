package com.wuhj.bytecode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuhaojie
 * @ClassName StringTest
 * @createTime 2020/5/29
 */
public class StringTest {

    public static void main(String[] args) {


        //String a = new String("123");

        String a = new String("zhangsan") + "wangwu";

        String b = a.intern();
        String c = "zhangsanwangwu";

        int i = System.identityHashCode(a);
        int x = System.identityHashCode(b);
        int y = System.identityHashCode(c);
        System.out.println(a == b);
        System.out.println(i);
        System.out.println(x);
        System.out.println(y);


        String s3 = new String("1") + new String("1");
        String intern = s3.intern();

        String s4 = "11";
        System.out.println(intern == s4);
    }
}
