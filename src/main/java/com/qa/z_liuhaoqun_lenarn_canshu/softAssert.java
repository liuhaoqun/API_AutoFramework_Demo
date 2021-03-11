package com.qa.z_liuhaoqun_lenarn_canshu;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * 硬断言就是，如果运行到折行断言失败，即使该用例，后面还有其他代码行，也不会继续执行下去。
 * 有时候我们不希望这种情况出现，SoftAssert就很好地帮我们解决了这个问题。
 * <p>
 * SoftAssert的特点
 * 1、如果一个断言失败，会继续执行这个断言下的其他语句或者断言。
 * 2、也就是一个用例有多个断言，失败了其中一个，不影响其他断言的运行
 * 3、不要忘记调用assertAll()在该用例的最后一个断言后面。
 */
public class softAssert {

    @Test
    public void softAssert() {
        System.out.println("Test start" + "softAssert");

        //实例化softAssert
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(12, 13, "两者不相等");
        System.out.println("Test complete");
        System.out.println(3 + 8);
        //这个必须放到最后，什么都没有说

        assertion.assertAll();
        /**
         * 使用说明：assertAll()一定要放在该测试类的最后一个断言后面，软断言的类，叫SoftAssert.java，
         * 这个类是需要创建实例对象，才能调用相关实例方法进行软断言。
         */
    }
}
