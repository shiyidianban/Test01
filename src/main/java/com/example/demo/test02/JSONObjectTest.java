package com.example.demo.test02;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author FLY
 * @Createdate 2019-12-13 16:00
 * @ProjectName Test01
 * @Desc com.example.demo.test02
 */
public class JSONObjectTest {

    public static void main(String[] args) {
        String data1 = "{\"data\":\"ok\"}";
//        String data1 = "{\"data\":{\"data\":\"ok\"}}";
        JSONObject json = JSONObject.parseObject(data1);
        if(json.get("data") instanceof  JSONObject){
            JSONObject jsonObject = (JSONObject) json.get("data");
            System.out.println(jsonObject.toString());
        }else{
            String str = json.getString("data");
            System.out.println(str);
        }
    }
}
