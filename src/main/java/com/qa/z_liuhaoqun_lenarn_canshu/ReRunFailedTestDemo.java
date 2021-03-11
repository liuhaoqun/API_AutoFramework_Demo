package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */
public class ReRunFailedTestDemo {

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test(dependsOnMethods = "test03", alwaysRun = true)
    public void test02() {
        System.out.println("test02");
    }

    @Test
    public void test03() {
        Assert.assertTrue(10 == 11);
        System.out.println("test03");
    }

    @Test(dependsOnMethods = "test05", alwaysRun = true)
    public void test04() {
        System.out.println("test04");
    }

    @Test
    public void test05() {
        Assert.assertTrue(12 == 13);
        System.out.println("test05");
    }

}
