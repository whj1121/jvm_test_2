package com.wuhj.classLoder;

/**
 * @author wuhaojie
 * @ClassName ClassLoaderTest
 * @createTime 2020/5/5
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        CustomizeLoader2 loader = new CustomizeLoader2();
        Class<?> aClass = loader.loadClass("com.wuhj.classLoder.Pig");
        aClass.getDeclaredConstructor().newInstance();

    }


}


