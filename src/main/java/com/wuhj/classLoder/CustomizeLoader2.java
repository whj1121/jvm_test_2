package com.wuhj.classLoder;

import lombok.Cleanup;

import java.io.*;

/**
 * @author wuhaojie
 * @ClassName CustomizeLoader
 * @createTime 2020/4/27
 */
public class CustomizeLoader2 extends ClassLoader {


    public CustomizeLoader2() {

    }

    public CustomizeLoader2(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] calssData = getCalssData(name);
       return this.defineClass(name, calssData, 0, calssData.length);

    }


    private byte[] getCalssData(String name) {
        name = name.replace(".", "/");
        File file = new File("/Users/a123456/Desktop/TestClass.class");
        byte[] bytes = null;
        try {
            @Cleanup
            ByteArrayOutputStream byteArrayOutputStream = null;
            @Cleanup
            FileInputStream fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = fileInputStream.read())) {
                byteArrayOutputStream.write(ch);
            }
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    public static void main(String[] args) throws Exception {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader.getParent().getParent());
        CustomizeLoader2 customizeLoader = new CustomizeLoader2();
        Class<?> aClass = Class.forName("com.wuhj.classLoder.TestClass", true, customizeLoader);
        Object o = aClass.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());
        System.out.println(o.getClass().getClassLoader());
    }
}
