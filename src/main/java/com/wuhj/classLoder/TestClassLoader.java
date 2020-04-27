package com.wuhj.classLoder;


/**
 * @author wuhaojie
 * @ClassName TestClassLoader
 * @createTime 2020/4/23
 */
public class TestClassLoader {

    public static void main(String[] args) throws Exception {

        /** 原生类型加载器是 null*/
        System.out.println("int classloader " + int.class.getClassLoader());
        /** 获取类的加载器*/
        System.out.println(C.class.getClassLoader());
        /**
         * 1.数组实例的类型是jvm在运行时生成的，所以数组类型的类加载器是和里面元素的类加载器相同的
         * 2 如果数组元素是原生类型（8中基本数据类型)，则类加载器是null
         */
        C[] c = new C[1];
        System.out.println("array classloader " + c.getClass().getClassLoader());
        /** 获取类加载器是否支持并行 */
        System.out.println(ClassLoader.getSystemClassLoader().isRegisteredAsParallelCapable());
        System.out.println(C.class.getClassLoader().isRegisteredAsParallelCapable());
        /** 获取当前线程的上下文的classLoader */
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        /** 设置当前线程的classloader */
        Thread thread = Thread.currentThread();
        System.out.println(thread.getContextClassLoader());
        System.out.println("---------");
        thread.setContextClassLoader(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(thread.getContextClassLoader());
    }
}

class C {


}

class B extends ClassLoader {

}
