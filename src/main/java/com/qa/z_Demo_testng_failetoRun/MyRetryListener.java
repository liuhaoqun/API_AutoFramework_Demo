package com.qa.z_Demo_testng_failetoRun;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */

/*
该接口的作用是在TestNG执行过程中动态改变测试类中Annotation的参数，当前这个接口主要是针对@Test注释。
IAnnotationTransformer监听器接口只有一个方法：
transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod).
下面我们写的几个类方法都是来源网上资料，都实现了上面提到的两个接口。
 */
public class MyRetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {

/*
上面我把test03比作是登录的用例，我根据平时的经验判断，这个登录可能会出现问题，这里我设置调用次数为3次，
也就是总共跑这个用例参数，运行下testNG.xml，会看到test03方法里的打印语句执行了三次
*/
        /*
        if("test03".equals(method.getName())){
            iTestAnnotation.setInvocationCount(3);
        }
        */

        IRetryAnalyzer myRetry = iTestAnnotation.getRetryAnalyzer();
        if (myRetry == null) {
            iTestAnnotation.setRetryAnalyzer(MyRetry.class);
        }
    }
    /**
     * 最后一段代码的意思就是对当前运行的用例先通过getRetryAnalyzer()获取重跑的次数的属性，如果属性为空，
     * 那么就设置我们自己设置的重跑次数（本文第一个类名称.class）
     */

    /**
     * 总结：
     * 失败重跑的总结：
     *
     * 通过对比这篇的实现方法和前面一篇我介绍的执行testng-failed.xml的方法，我还是比较喜欢第一种方法。
     * 由于我们经常对自己行项目的用例执行一次大概需要多长时间，所以我们完全可以采用第一种方法。
     * 这样的好处就是，我不用写监听，每次只管跑用例，设置一个足够让用例完成的时间，然后再把执行testng-failed.xml文件，
     * 这样就默认把全部失败的用例给再次执行了一遍。至于设置执行次数的问题，个人觉得失败一次和失败两次没有太大区别，
     * 跑第五次失败的可能性还是很大，再说设置一个for循环执行三遍testng-failed.xml也可以达到这个目的。
     */
}
