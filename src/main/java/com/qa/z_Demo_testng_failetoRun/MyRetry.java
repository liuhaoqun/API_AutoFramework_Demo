package com.qa.z_Demo_testng_failetoRun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */

/*
    该接口的作用是提供去实现能够让用例运行失败重跑的设置。实现该接口必须要实现retry(ITestResult result)这个方法。
    返回值类型是布尔型，如果返回是True，那么就执行失败重跑，返回是false，就不重跑。
    参数result是当前运行的测试用例的结果状态
 */
public class MyRetry implements IRetryAnalyzer {
    //设置当前失败执行次数
    private int retryCount = 1;
    //设置最大失败执行次数
    private static int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
