package com.example.demo.test02.clazz;

import lombok.Data;

/**
 * @Author FLY
 * @Createdate 2019-12-14 10:37
 * @ProjectName Test01
 * @Desc com.example.demo.test02.clazz
 */
@Data
public class ClassLoaderTest01 {

    private String t1;

    public static void main(String[] args) {
        Integer i = 0;
        System.out.println(String.class.getClassLoader());
        System.out.println(Integer.class.getClassLoader());
    }
}
