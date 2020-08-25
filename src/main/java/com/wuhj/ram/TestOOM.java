package com.wuhj.ram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuhaojie
 * @ClassName TestOOM
 * @createTime 2020/5/28
 */
public class TestOOM {

    public static void main(String[] args) {

        List<TestOOM> list = new ArrayList<>();
        while (true) {
            list.add(new TestOOM());
        }
    }
}
