package com.example.demo.test02.clazz;

import lombok.Data;

/**
 * @author FLY
 * @date 2019-12-14 10:37
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
