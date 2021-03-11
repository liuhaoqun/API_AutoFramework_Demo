package com.qa.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Create By ${liuhaoqun} on 2021/3/8.
 */
public class TestUtil {
    /**
     * @param responseJson                        ,这个变量是拿到响应字符串通过json转换成json对象
     * @param jpath,这个jpath指的是用户想要查询json对象的值的路径写法 jpath写法举例：1) per_page  2)data[1]/first_name ，data是一个json数组，[1]表示索引
     *                                            /first_name 表示data数组下某一个元素下的json对象的名称为first_name
     * @return，返回first_name这个json对象名称对应的值
     */

    /*
    简单解释下上面的代码，主要是查询两种json对象的的值，第一种最简单的，这个json对象在整个json串的第一层，
    例如上面截图中的per_page，这个per_page就是通过jpath这个参数传入，返回的结果就是3. 第二种jpath的查询，
    例如我想查询data下第一个用户信息里面的first_name的值，这个时候jpath的写法就是data[0]/first_name，
    查询结果应该是Eve。

     */


    //1.json解析方法
    public static String getValueByJPath(JSONObject responseJson, String jpath) {
        Object obj = responseJson;
        // String s1 = responseJson.getValueByJPath();
        for (String s : jpath.split("/")) {   //遍历循环，，，提取第一个元素的名字，
            if (!s.isEmpty()) {
                if (!(s.contains("[") || s.contains("]"))) {
                    obj = (((JSONObject) obj).get(s));
                } else if ((s.contains("[") || s.contains("]"))) {
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0]))
                            .get(Integer.parseInt(s.split("\\[")[1]
                                    .replaceAll("]", "")));
                }
            }
        }
        return obj.toString();
    }
}
