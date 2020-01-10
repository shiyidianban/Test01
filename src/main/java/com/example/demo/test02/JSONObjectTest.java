package com.example.demo.test02;

import com.alibaba.fastjson.JSONObject;

/**
 * @author FLY
 * @date 2019-12-13 16:00
 */
public class JSONObjectTest {

    public static void main(String[] args) {
        String data1 = "{\"data\":\"ok\"}";
//        String data1 = "{\"data\":{\"data\":\"ok\"}}";
        JSONObject json = JSONObject.parseObject(data1);
        if (json.get("data") instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) json.get("data");
            System.out.println(jsonObject.toString());
        } else {
            String str = json.getString("data");
            System.out.println(str);
        }
    }
}
