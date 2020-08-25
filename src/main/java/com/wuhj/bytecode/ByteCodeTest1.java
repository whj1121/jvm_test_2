package com.wuhj.bytecode;

import com.wuhj.classLoder.ClassLoaderTest2;
import com.wuhj.classLoder.MysqlTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuhaojie
 * @ClassName ByteCodeTest1
 * @createTime 2020/5/9
 */
/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class ByteCodeTest1 {

    private int a = 1;

   private static  String b = "123";

   private ClassLoaderTest2 test2;

    static {

    }

    public int getA() {
        return a;
    }

    private void setA(int a) {
        this.a = a;
    }

}
