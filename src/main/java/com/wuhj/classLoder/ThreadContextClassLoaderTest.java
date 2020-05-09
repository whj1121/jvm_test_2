package com.wuhj.classLoder;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author wuhaojie
 * @ClassName ThreadContextClassLoaderTest
 * @createTime 2020/5/7
 */
public class ThreadContextClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {
            Driver next = iterator.next();
            System.out.println(next.getClass().getClassLoader());
        }



        //Thread.currentThread().setContextClassLoader(ClassLoader.getSystemClassLoader().getParent());
        DriverManager.getConnection("jdb:mysql://localhost:3306", "1", "2");
        CustomizeLoader2 loader2 = new CustomizeLoader2(ClassLoader.getSystemClassLoader().getParent());
        Class.forName("com.wuhj.classLoder.MysqlTest", true, loader2);
    }
}
