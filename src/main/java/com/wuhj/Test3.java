package com.wuhj;

import java.util.Random;

/**
 * @author wuhaojie
 * @ClassName Test3
 * @createTime 2020/4/21
 */
public class Test3 {

    public static void main(String[] args) throws Exception{

        System.out.println(MyChild.child);
        System.out.println(Object.class.getClassLoader());
        //System.out.println(MyParent.class.getName());
        //ClassLoader.getSystemClassLoader().loadClass(MyParent.class.getName());
        //Class.forName(MyParent.class.getName());
        //MyParent[] myParents = new MyParent[1];
        //System.out.println(myParents.getClass());
    }
}

interface MyParent {
    public static final int parent = new Random().nextInt(1);
    static Thread thread = new Thread() {
        {
            System.out.println("初始化MyParent");
        }
    };

}

class MyChild implements MyParent {
    public static final int child = new Random().nextInt(1);
    static Thread thread = new Thread() {
        {
            System.out.println("初始化MyChild");
        }
    };

}

