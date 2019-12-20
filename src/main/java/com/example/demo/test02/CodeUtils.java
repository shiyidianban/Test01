package com.example.demo.test02;

import java.util.UUID;

/**
 * @author zhuxucheng
 * @date 2019-11-14 7:28 PM
 */
public class CodeUtils {

    private CodeUtils() {
    }


    /**
     * 生成唯一编码
     *
     * @return
     */
    public static String uniqueCode() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
