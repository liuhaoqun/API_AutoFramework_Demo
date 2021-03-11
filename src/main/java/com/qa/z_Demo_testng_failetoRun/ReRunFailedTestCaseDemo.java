package com.qa.z_Demo_testng_failetoRun;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */
public class ReRunFailedTestCaseDemo {

    @Test
    public void test01() {
        System.out.println("test001");
    }

    @Test
    public void test02() {
        Assert.assertTrue(10 == 11);
        System.out.println("test002");
    }

    @Test
    public void test03() {
        System.out.println("test003");
    }
}
