package com.wuhj.ram;

/**
 * @author wuhaojie
 * @ClassName StringTestClass
 * @createTime 2020/6/10
 */
public class StringTestClass {

    public static void main(String[] args) {

//        String a = "a";
//        String b = "b" + a;
//        String c = new String("ab");
//        System.out.println(b.intern() == c);

        String a = "a";
        String param = "b" + a;
        //这里的"ba"为字面量不应该在类加载后就进入常量池了吗
        //(查看字节码也可以看到它被放到了constant pool),那么param应该不会放到pool中啊
        //System.out.println(param.intern().equals("ba"));
        System.out.println(param == "ba");
        System.out.println(param.intern() == "ba");
        //System.out.println(param.equals("ba"));
        String intern = param.intern();


/*        String s1 = new String("kvill");
        String s2 = "kvill";

        System.out.println(s1 == s1.intern());
        System.out.println(s2 == s1.intern());*/

    }
}
