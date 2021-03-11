package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */
public class dependsOnMethods {

    @Test(dependsOnMethods = {"test2", "test3"})
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }
}
