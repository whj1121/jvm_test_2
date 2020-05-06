package com.wuhj.classLoder;

/**
 * @author wuhaojie
 * @ClassName Dog
 * @createTime 2020/5/5
 */
public class Dog {
    public Dog() {
        System.out.println("dog class loader " + Dog.class.getClassLoader());
        System.out.println(Pig.class);
    }
}
