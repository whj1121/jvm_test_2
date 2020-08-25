package com.wuhj.classLoder;

/**
 * @author wuhaojie
 * @ClassName ClassLoaderTest2
 * @createTime 2020/5/5
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getClassLoader());
        //System.out.println(ClassLoader.getPlatformClassLoader().getClass().getClassLoader());
    }
}
