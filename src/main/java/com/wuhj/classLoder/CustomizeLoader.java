package com.wuhj.classLoder;

import lombok.Cleanup;

import java.io.*;

/**
 * @author wuhaojie
 * @ClassName CustomizeLoader
 * @createTime 2020/4/27
 */
public class CustomizeLoader extends ClassLoader {


    public CustomizeLoader() {

    }

    public CustomizeLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] calssData = getCalssData(name);
        return this.defineClass(name, calssData, 0, calssData.length);
        /**
         * 注意一定要把这行删掉，网上很多例子都有这行代码。
         * 这行代码是调用父类的findClass(),能执行到我们自定义个的类加载器的findClass()说明父类是无法处理加载请求的
         * 这里再次调用super.findClass(name)的时候就会抛出ClassNotFoundException
         * */
        //return super.findClass(name);

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

    public static void main(String[] args) throws Exception {
        /**
         * 默认情况下我们自定义的类加载器的parent是系统类加载器
         * 因为我们加载的类是在classPath路径下面的，所以会被系统类加载器加载，我们自定义的加载器就不会起作用
         * 这里把自定义的类加载器的parent给修改成系统类的parent，这样就能确保我们自定义的类加载器可以发挥作用
         * 如果需要加载的class文件坐在位置不在classPath下面，就不用单独设置parent
         * */
        CustomizeLoader customizeLoader = new CustomizeLoader(ClassLoader.getSystemClassLoader().getParent());
        Class<?> aClass = Class.forName("com.wuhj.classLoder.TestClassLoader", true, customizeLoader);
        Object o = aClass.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());
        System.out.println(o.getClass().getClassLoader());
    }
}
