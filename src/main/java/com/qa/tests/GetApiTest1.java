package com.qa.tests;

import com.qa.base.TestBase1;
import com.qa.restclient.RestClient1;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Create By ${liuhaoqun} on 2021/3/8.
 */
public class GetApiTest1 extends TestBase1 {

    TestBase1 testBase;
    String host;
    String url;
    RestClient1 restClient;


    @BeforeClass
    public void setUp() {
        testBase = new TestBase1();
        host = new GetApiTest1().prop.getProperty("HOST");
        url = host + "/api/users";
    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        restClient = new RestClient1();
        restClient.get(url);
    }

}