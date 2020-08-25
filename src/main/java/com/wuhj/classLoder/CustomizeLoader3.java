package com.wuhj.classLoder;

import lombok.Cleanup;

import java.io.*;

/**
 * @author wuhaojie
 * @ClassName CustomizeLoader
 * @createTime 2020/4/27
 */
public class CustomizeLoader3 extends ClassLoader {


    public CustomizeLoader3() {

    }

    public CustomizeLoader3(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] calssData = getCalssData(name);
        return this.defineClass(name, calssData, 0, calssData.length);

    }


    private byte[] getCalssData(String name) {
        name = name.replace(".", "/");
        File file = new File("/Users/a123456/IdeaProjects/wuhj-test/jvm_test_2/target/classes/" + name + ".class");
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

    /**测试自定义类加载器所加载的类可以被卸载 */
    public static void main(String[] args) throws Exception {
        CustomizeLoader3 customizeLoader = new CustomizeLoader3(ClassLoader.getSystemClassLoader().getParent());
        Class<?> aClass = Class.forName("com.wuhj.classLoder.TestClassLoader", true, customizeLoader);
        Object o = aClass.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass().getClassLoader());
        o = null;
        customizeLoader = null;
        aClass = null;
        System.gc();
        Thread.sleep(200000);
    }
}
