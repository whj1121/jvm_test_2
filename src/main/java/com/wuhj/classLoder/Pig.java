package com.wuhj.classLoder;

/**
 * @author wuhaojie
 * @ClassName Pig
 * @createTime 2020/5/5
 */
public class Pig {
    public Pig() {
        System.out.println("Pig class loader " + Pig.class.getClassLoader());
        new Dog();
    }
}
