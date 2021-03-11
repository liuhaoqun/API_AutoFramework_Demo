package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/9.
 */
public class enabled_priopity {

    @Test
    public void test1() {
        System.out.println("test1");
    }

    //设置为false，不能被执行
    @Test(enabled = false)
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }


    //priority,设置方法执行的优先顺序
    @Test(priority = 3)
    public void test11() {
        System.out.println("test11");
    }

    //设置为false，不能被执行
    @Test(priority = 2)
    public void test12() {
        System.out.println("test12");
    }

    @Test(priority = 1)
    public void test13() {
        System.out.println("test13");
    }

}
