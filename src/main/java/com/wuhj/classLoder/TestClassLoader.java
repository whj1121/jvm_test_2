package com.wuhj.classLoder;

/**
 * @author wuhaojie
 * @ClassName TestClassLoader
 * @createTime 2020/4/23
 */
public class TestClassLoader {

    public static void main(String[] args) throws Exception {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getContextClassLoader());
        System.out.println(TestClassLoader.class.getClassLoader());
        System.out.println("---------");
        thread.setContextClassLoader(ClassLoader.getPlatformClassLoader());
        System.out.println(thread.getContextClassLoader());
        thread.getContextClassLoader();
        System.out.println(int.class.getClassLoader());
        /** 获取类的加载器*/
        System.out.println(A.class.getClassLoader());
        /**
         * 1.数组实例的类型是jvm在运行时生成的，所以数组类型的类加载器是和里面元素的类加载器相同的
         * 2 如果数组元素是原生类型（例如）
         */
        A[] a = new A[1];
        System.out.println(a.getClass().getClassLoader());
        /** 获取类加载器是否支持并行 */
        System.out.println(ClassLoader.getSystemClassLoader().isRegisteredAsParallelCapable());
        System.out.println(A.class.getClassLoader().isRegisteredAsParallelCapable());
        /** 获取当前线程的上下文的classLoader */
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
}

class A {


}

class B extends ClassLoader {

}
