package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */
public class invocationCount {

    /*
    invocation,这个测试用例被调用执行的次数。说明这个属性可以设置一个用例可以重复跑多次;
    invocationTimeOut,
    第一个是设置一个最大的毫秒数来计算执行多次后总共耗时多少，耗时值不能超过设置的最大毫秒数。
    第二个意思是说，这个属性是和invocationCount结合使用才会工作
     */

    @Test(invocationCount = 5, invocationTimeOut = 5100)
    public void logintest() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("login test");
    }
/*
TODO:这两个参数有什么用处：我们可以测接口被调用多次，需要的响应时间。。。。。。
这两个参数有什么作用呢？在接口测试中，或者性能测试。我们需要测试某一个功能的稳定性。
例如，一个支付接口，调用一次，能够在1秒完成。那么如果调用100次，1万次，甚至更多次数。
随着服务器压力增加，不可能每次接口执行都是1秒。例如，我测试支付接口10次，总响应时间不能超过13秒。
如果测试超过13秒，说明这个接口性能角度，或者压力测试角度，稳定性角度是有缺陷的，需要开发去想办法优化。
 */
}
