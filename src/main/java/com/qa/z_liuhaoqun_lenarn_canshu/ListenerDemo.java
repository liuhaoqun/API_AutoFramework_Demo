package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */

/**
 * 测试class是运行失败的，但是控制台有输出，说明   设置的用例启动和失败监听方法得到了执行。。。
 */
public class ListenerDemo implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("用例启动。" + iTestResult.toString());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("用例执行成功。" + iTestResult.toString());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("用例执行失败，启动截图");
        //调用截图方法
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Test
    public void listenerExempleTest() {
        Assert.assertTrue(11 == 10);
    }

}
