package com.example.demo.test02.clazz;

import java.lang.reflect.Field;

/**
 * @Author FLY
 * @Createdate 2019-12-14 16:02
 * @ProjectName Test01
 * @Desc com.example.demo.test02.clazz
 */
public class ReflectionFields {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        //加载Class对象
        //会报出不存在该类的异常
        Class c=Class.forName("com.example.demo.test02.model.Student");

        //获取所有公用公共字段
        System.out.println("================获取所有公共字段=================");
        Field[] fields=c.getFields();
        for (Field field:fields) {
            System.out.println("公共字段:"+field);
        }
        //获取所有字段
        System.out.println("================获取所有的字段（公共的、私有的）=================");
        Field[] declaredFields=c.getDeclaredFields();
        for (Field declaredfield:declaredFields) {
            System.out.println("所有字段:"+declaredfield);
        }

        System.out.println("================根据字段名获取公共字段=================");
        //根据字段名获取公共字段
        Field field1=c.getField("name");
        System.out.println("根据字段名获取公共字段:"+field1);

        System.out.println("================根据字段名私有字段=================");
        //根据字段名获取公共字段
        Field field2=c.getDeclaredField("age");
        System.out.println("根据字段名获取公共字段:"+field2);

    }
}
