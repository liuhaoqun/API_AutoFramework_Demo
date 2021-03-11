package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/9.
 */
public class my_test_Parameters {
    //@Paramters    必须从  .xml运行，才能获取到配置的参数
    @Test
    @Parameters({"Browser", "Server"})  //必须从  .xml运行，才能获取到配置的参数
    public void test4(String browser, String server) {
        System.out.println("你好");
        System.out.println("这次启动的浏览器是：" + browser + ",测试人员是：" + server);
    }
}
