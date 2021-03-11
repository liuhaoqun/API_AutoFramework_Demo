package com.qa.z_liuhaoqun_lenarn_canshu;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */

/*
接口常见测试流程
1、发送接口请求
2、断言接口响应状态是不是200 OK
3、断言接口的响应时间低于某一个值（看情况，不是必选）
4、断言响应数据是否正确，一般的做法是判断某一个值是否相等或者包含关系。。****最主要断言方式

步骤4主要方式，因为接口请求回来，会得到很多参数返回，一般是json数据，一般只能够对其中几个json字符串进行断言比较，
有些能够通过两个json文件对比，一个是直接从数据库请求的json数据文件，一个是接口请求得到的json文件。

TestNG提供的断言操作。TestNG中最常用的一个断言类是Assert.java,里面有多个静态方法，这个类我们习惯叫硬断言。
对应的还有一个软断言的类，叫SoftAssert.java，这个类是需要创建实例对象，才能调用相关实例方法进行软断言。

 */
public class HardAssert_softAssert {

    @Test
    public void AssertTest() {

        Assert.assertEquals(12, 12);
        Assert.assertEquals("ABc", "ABC", "not equals");
    }


    //assertEqualsNoOrder,判断两个对象是否相同，忽略排序位置
    @Test
    public void AssertTest2() {

        String[] st1 = {"Anthony", "Tom", "Jhon"};
        String[] st2 = {"Jhon", "Anthony", "Tom"};
        Assert.assertEqualsNoOrder(st1, st2, "两个字符串数组不相同");
    }


    //assertFalse(布尔条件，“message1”)。
    //断言为假的方法，断言一个条件，如果返回是假，则测试通过，如果返回是真，抛出断言异常，打印message1的内容。
    @Test
    public void AssertTest3() {

        String[] st1 = {"Anthony", "Tom", "Jhon"};
        String[] st2 = {"Jhon", "Anthony", "Tom"};
        Assert.assertFalse(st1 == st2, "两个相等");
    }

    //assertNotEquals(actual, expect, “message1”)
    //提供“不相等”断言方法，也是有6个针对不同数据类型的不相等的断言方法。
    // 这里我们介绍两个对象的不相等举例，如果相等，输出message1的内容。
    @Test
    public void AssertTest4() {

        String[] st1 = {"Anthony", "Tom", "Jhon"};
        String[] st2 = {"Jhon", "Anthony", "Tom"};
        Assert.assertNotEquals(st1, st2, "两者相等");
    }


    //assertNotNull(object, “message1”)
    //对象非空判断，断言对象不为空，否则，抛出异常，打印message1的内容。
    @Test
    public void AssertTest5() {
        String[] st1 = {"Anthony", "Tom", "Jhon"};
        String[] st2 = {"Jhon", "Anthony", "Tom"};
        String[] st4 = null;
        Assert.assertNotNull(st1, "该对象为空");
        Assert.assertNotNull(st4, "该对象为空");

    }

    //assertSame(actual, expect, “message”)
    //断言两个对象相同，这里相同和上面的Equals不同，Equals是值比较，而Same是内存地址比较
    @Test
    public void AssertTest6() {
        String[] st1 = {"Anthony", "Tom", "Jhon"};
        String[] st2 = {"Jhon", "Anthony", "Tom"};
        String[] st3 = st1;

        Assert.assertSame(st1, st3, "not same");
        //Assert.assertSame(st1, st2, "not same");

        //assertNotSame(actual, expect, “message”)
        //同样的，也有断言两个对象内存地址不相同的断言方法。
        Assert.assertNotSame(st1, st2, "not same");

        Assert.assertTrue(st1 == st3, "两者不相同");
    }
}
