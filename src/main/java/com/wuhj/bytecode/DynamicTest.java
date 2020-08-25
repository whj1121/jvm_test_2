package com.wuhj.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuhaojie
 * @ClassName DynamicTest
 * @createTime 2020/5/24
 */
public class DynamicTest {

   static HashMap<Integer, String>  map = new HashMap<Integer, String>(2);
    public static void main(String[] args) {

       /* System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Hello hello = new Hello();
        IHello iHello = (IHello) Proxy.newProxyInstance(Hello.class.getClassLoader(), Hello.class.getInterfaces(), new DynamicPorxy(hello));
        iHello.sayHi();
        iHello.toString();*/
        /*String a = "3";
        String b = "5";
        String c = "7";*/
        Integer a = 3;
        Integer b = 5;
        Integer c = 7;
        System.out.println("3 hashcode"+ a.hashCode());
        System.out.println("5 hashcode"+ b.hashCode());
        System.out.println("7 hashcode"+ c.hashCode());
        map.put(5, "C");
        new Thread("Thread1") {
            @Override
            public void run() {
                map.put(3, "A");

            }
        }.start();

        new Thread("Thread2") {
            @Override
            public void run() {
                map.put(7, "B");
                map.get(3);
            }
        }.start();

        System.out.println(3 % 2);
        System.out.println(5 % 2);
        System.out.println(7 % 2);
        System.out.println(3 % 4);
        System.out.println(7 % 4);
        System.out.println(map.get(3));



    }


    // 线程1 e = 3 next = 7
    // 线程2 e = 7 next = 3
    // 1 e.next = newTable[i] = 7
    // 2. newTable[i] = e; -> newTable[i] = 3


}

interface IHello{
    void sayHi();
}

class Hello implements IHello {
    @Override
    public void sayHi() {
        System.out.println("hello");
    }

}

class DynamicPorxy implements InvocationHandler {

    private Object object;

    public DynamicPorxy(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(object, args);
        System.out.println("after");
        return null;
    }

}



