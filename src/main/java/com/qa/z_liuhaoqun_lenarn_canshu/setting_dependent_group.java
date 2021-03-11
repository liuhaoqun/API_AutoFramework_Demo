package com.qa.z_liuhaoqun_lenarn_canshu;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */

import org.testng.annotations.Test;

/**
 * dependOnGroups和如何在testng.xml中设置依赖关系。在Testng中依赖分两种，硬依赖和软依赖。
 * 硬依赖就是所有的依赖方法必须成功执行，才会执行接下来的方法，
 * 如果其中有一个依赖的方法失败了，那么接下来的方法是不会被执行，会默认标记跳过（skip）。
 */


public class setting_dependent_group {

 /*   public static  class eg{
        @Test(dependsOnMethods = "tomcatServiceIsDown")
        public void restartTomcatService(){
            System.out.println("Restart the tomcat server when it is down!");
        }
        @Test
        public void tomcatServiceIsDown(){
            System.out.println("tomcat service is down!");
        }
//         * 上面重启tomcat服务的方法运行的前提是tomcatServiceIsDown()，
//         * 只有tomcat服务确实挂了，才会执行重启的方法，这个就是硬依赖。
//         *
//         * 软依赖就是不管依赖的方法是否成功执行，接下来的方法都可以运行。
//         * 软依赖的实现是在@Test中添加属性alwaysRun=true来实现
//
    }
*/


    //软依赖
    @Test(groups = {"tomcat"})
    public void restartTomcatService() {
        System.out.println("Restart the tomcat server when it is down!");
    }

    @Test(groups = {"tomcat"})
    public void tomcatServiceIsDown() {
        System.out.println("tomcat service is down!");
    }

    @Test(groups = {"app"})
    public void startAppServer() {
        System.out.println("Start App service");
    }

    @Test(groups = {"app"})
    public void shutDownApp() {
        System.out.println("Shutdown App service");
    }


}
