package com.qa.restclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

/**
 * Create By ${liuhaoqun} on 2021/3/8.
 */
public class RestClient1 {

    //1、GET请求方法
    public void get(String url) throws ClientProtocolException, IOException {

        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);
        //执行请求，相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);

        //拿到http响应状态码，例如200，404，500去比较
        int responseStstusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("response status code --->" + responseStstusCode);

        //把响应内容存储在字符串对象
        String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

        //创建JSON对象，把上面字符串序列化成JSON对象
        JSONObject responseJson = JSON.parseObject(responseString);
        System.out.println(responseJson);

        //获取响应头信息，返回是一个数组
        Header[] headerArray = httpResponse.getAllHeaders();
        //创建一个hashmap对象，通过postman可以看到请求响应头信息都是key和value的形式，所以我们才会用hashmap
        HashMap<String, String> hashMapm = new HashMap<>();
        //增强for循环，遍历headerArray数组，以此把元素添加到hashmap集合
        for (Header header : headerArray) {
            hashMapm.put(header.getName(), header.getValue());
        }

        //打印hashmap
        System.out.println("response header --->" + hashMapm);


    }
}
