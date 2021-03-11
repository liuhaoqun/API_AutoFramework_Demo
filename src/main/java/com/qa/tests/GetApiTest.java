package com.qa.tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.restclient.RestClient;
import com.qa.util.TestUtil;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.qa.base.TestBase.prop;
import static com.qa.base.TestBase.RESPNSE_STATUS_CODE_200;

/**
 * Create By ${liuhaoqun} on 2021/3/8.
 */
public class GetApiTest {

    TestBase testBase;
    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host + "/api/users?page=2";
    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        restClient = new RestClient();
        closeableHttpResponse = restClient.get(url);

        //System.out.println("wo 11 "+closeableHttpResponse);
        //System.out.println("wo 22 "+closeableHttpResponse.getStatusLine());
        //System.out.println("wo 33 "+closeableHttpResponse.getStatusLine().getStatusCode());


        //获取响应，调用方法 获取get状态行，然后是获取状态
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        //String ss = closeableHttpResponse.getParams().getParameter("data");
        //断言状态码是不是正确200
        Assert.assertEquals(statusCode, RESPNSE_STATUS_CODE_200, "response status code is not 200");


        //把响应内容存储在字符串对象
        //使用httpclient 请求的时候，使用EntityUtils 对返回的结果进行字符串的转换..。也可以调用consume（）方法，关流
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        System.out.println("wo 55" + responseString);
        //创建Json对象，把上面字符串序列化成Json对象
        JSONObject responseJson = JSON.parseObject(responseString);
        System.out.println("respon json from APi ---->" + responseJson);

        //json内容解析
        String s = TestUtil.getValueByJPath(responseJson, "data[0]/first_name");
        System.out.println(s);
        Assert.assertEquals(s, "Michael", "first name is not Eve");

    }
}
