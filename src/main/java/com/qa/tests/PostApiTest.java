package com.qa.tests;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.data.Users;
import com.qa.restclient.RestClient;
import com.qa.util.TestUtil;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static com.qa.base.TestBase.RESPNSE_STATUS_CODE_201;
import static com.qa.base.TestBase.prop;

/**
 * Create By ${liuhaoqun} on 2021/3/9.
 */
public class PostApiTest {

    TestBase testBase;
    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host + "/api/users";
    }

    @Test
    public void postApiTest() throws ClientProtocolException, IOException {
        restClient = new RestClient();

        //准备请求头信息====用来做什么的，，，，，
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json"); //这个是在postman中可以查询到

        //对象转换成JSON字符串
        Users users = new Users("morpheus", "tester");
        String userJsonString = JSON.toJSONString(users);
        System.out.println("woziji" + userJsonString);

        closeableHttpResponse = restClient.post(url, userJsonString, hashMap);  //调用方法

        //验证状态码是不是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, RESPNSE_STATUS_CODE_201, "status code is not 201");

        //断言响应json内容中name和job是不是期待结果
        String responseSting = EntityUtils.toString(closeableHttpResponse.getEntity());
        JSONObject responseJson = JSON.parseObject(responseSting);
        //System.out.println(responseJson);

        String name = TestUtil.getValueByJPath(responseJson, "name");
        String job = TestUtil.getValueByJPath(responseJson, "job");
        Assert.assertEquals(name, "morpheus", "name is not same");
        Assert.assertEquals(job, "tester", "job is not same");

    }

}
