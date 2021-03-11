package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Create By ${liuhaoqun} on 2021/3/8.
 */
public class TestBase {
    public static Properties prop;
    public static int RESPNSE_STATUS_CODE_200 = 200;
    public static int RESPNSE_STATUS_CODE_201 = 201;
    public int RESPNSE_STATUS_CODE_404 = 404;
    public int RESPNSE_STATUS_CODE_500 = 500;

    public TestBase() {
        try {
            prop = new Properties();
            //读取文件，，，getProperty(user.dir)获取程序执行路径，+“XXX”，读取配置文件路径；；
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/com/qa/config/config.properties");

            System.out.println(System.getProperty("user.dir") + "wowowo");
            //加载配置文件
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
