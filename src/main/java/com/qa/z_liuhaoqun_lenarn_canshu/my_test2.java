package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/9.
 */
public class my_test2 {

    @BeforeClass
    public void setUp() {
        System.out.println("启动之前的前提条件准备，一般放在这个方法中");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("测试运行结束后的步骤，一般恢复测试环境回到测试之前");
    }

    @Test
    public void test() {
        System.out.println("hello");
    }

    @Test
    @Parameters({"Browser", "Server"})
    public void test4(String browser, String server) {
        System.out.println("你好");
        System.out.println("这次启动的浏览器是：" + browser + ",测试人员是：" + server);
    }
}
