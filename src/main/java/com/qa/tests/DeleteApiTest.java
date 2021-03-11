package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.restclient.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.qa.base.TestBase.prop;

/**
 * Create By ${liuhaoqun} on 2021/3/9.
 */
public class DeleteApiTest {
    TestBase testBase;
    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;


    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host + "/api/users/2";  //直接在这个网站可以找到delete的api

    }

    @Test
    public void deleteApiTest() throws ClientProtocolException, IOException {
        restClient = new RestClient();
        closeableHttpResponse = restClient.delete(url);

        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 204, "status code is not 204");
    }

    @Test
    public void test1() {
        System.out.println("hello");
    }
}


