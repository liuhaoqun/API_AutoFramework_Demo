package com.qa.restclient;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Create By ${liuhaoqun} on 2021/3/8.
 * <p>
 * 在前面文章，说过，之前写的Get方法比较繁琐，不光写了如何进行Get请求，还写了获取http响应状态码和JSON转换。
 * 现在我们需要抽取出来，设计Get请求方法，就只干一件事情，那就是如何发送get请求，其他的不要管。
 * <p>
 * 我们知道，请求之后会返回一个HTTP的响应对象，所以，我们把get方法的返回值类型改成了响应对象，并带上返回语句，
 * 重构代码之后，get方法代码如下。
 */
public class RestClient {

    //1.Get 请求方法
    public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
        //创建一个可以关闭的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpGet = new HttpGet(url);
        //执行请求，相当于postman上点击发送按钮，然后赋值给Httpresonse对象接收
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        return httpResponse;
    }

    //2.Get 请求方法（带请求头信息）
    public CloseableHttpResponse get(String url, HashMap<String, String> hashMap) throws ClientProtocolException, IOException {

        //创建一个可关闭的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpGet = new HttpGet(url);
        //加载请求头到httpget对象
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            httpGet.addHeader(entry.getKey(), entry.getValue());
        }
        //执行请求,相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        return httpResponse;
    }

    //3.POST方法
    public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> hashMap) throws ClientProtocolException, IOException {
        //创建一个可关闭的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个HttpPost的请求对象
        HttpPost httpPost = new HttpPost(url);
        //设置payload
        httpPost.setEntity(new StringEntity(entityString));

        //加载请求头到httppost对象
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }

        //发送post请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        return httpResponse;
    }

    //4.PUT方法
    public CloseableHttpResponse put(String url, String entityString, HashMap<String, String> hashMap) throws ClientProtocolException, IOException {
        //创建一个可关闭的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个HttpPost的请求对象
        HttpPut httpPut = new HttpPut(url);
        //
        httpPut.setEntity(new StringEntity(entityString));

        //加载请求头到httppost对象
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            httpPut.addHeader(entry.getKey(), entry.getValue());
        }

        //发送post请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPut);
        return httpResponse;
    }

    //5.Delete方法
    public CloseableHttpResponse delete(String url) throws ClientProtocolException, IOException {
        //创建一个可关闭的httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个HttpPost的请求对象
        HttpDelete httpDelete = new HttpDelete(url);

        //发送put请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpDelete);
        return httpResponse;
    }


}
