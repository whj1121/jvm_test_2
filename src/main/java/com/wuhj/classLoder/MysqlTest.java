package com.wuhj.classLoder;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wuhaojie
 * @ClassName MysqlTest
 * @createTime 2020/5/7
 */
public class MysqlTest {
    static {

        try {
            DriverManager.getConnection("jdb:mysql://localhost:3306", "1", "2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
