package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */
public class testng_group {

    @Test(groups = {"API Test", "Function Test"})
    public void test01() {
        System.out.println("API Test and function test");
    }

    @Test(groups = {"API Test"})
    public void test02() {
        System.out.println("API testing");
    }

    @Test(groups = {"Function testing"})
    public void test03() {
        System.out.println("Function testing");
    }

    @Test
    public void test04() {
        System.out.println("Not Api and function testing");
    }
}
