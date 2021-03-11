package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */

/**
 * 执行失败的case用例
 */
public class a_first_ReRunTestNg {

    public static void main(String[] args) throws InterruptedException {

        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add(".\\src\\temp-testng-customsuite.xml");
        //suites.add(".\\test-output\\testng-failed.xml");
        testNG.setTestSuites(suites);
        testNG.run();
        System.out.println("执行第一次");


        // 等待执行结束，然后去执行失败用例
        TestNG testNG1 = new TestNG();
        List<String> suites1 = new ArrayList<String>();
        Thread.sleep(5000);
        suites1.add(".\\test-output\\testng-failed.xml");
        testNG1.setTestSuites(suites1);
        testNG1.run();
        System.out.println("再次执行一次");


    }
}
