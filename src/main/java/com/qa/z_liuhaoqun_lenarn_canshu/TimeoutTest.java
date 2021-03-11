package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */
public class TimeoutTest {

    @Test(timeOut = 3000)
    public void logintest() {
        try {
            Thread.sleep(2800);
        } catch (InterruptedException e) {

            //简单阻塞状态，当其地方调用到该线程的interrupt（）方法时，该线程如果执行在这个过程内，会抛出异常
            //用户自定义的收尾工作
            System.out.println(e.toString());
            e.printStackTrace();
        }

        if (Thread.currentThread().isInterrupted()) {
            //复杂的阻塞状态
            //用户可以手动判断是否需要收尾
        }
    }
    /*
为什么要抛出有这个异常存在呢？它的作用是什么？
因为目前Java没有提供一种安全直接的方法来直接停止某个线程！！！没有任何java语言方面的需求要求一个被中断的程序应该终止。
中断一个线程只是为了引起该线程的注意，被中断线程可以决定如何应对中断

为了解决这个问题，java给出了这样一个设计方案，提供了一种中断策略：
1.提供一种标记方式，用来标记是否需要中断。
2.提供一种检测标记状态方式，检测该标记
3.对于简单的阻塞状态（可响应中断），通过抛出InterruptedException异常的方式，
4.对于复杂的阻塞状态（不可响应中断），通过上层主动在代码中判断该标记的状态，去决定各种自定义的处理方式。
     */
}
