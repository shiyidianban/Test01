package com.example.demo.test02.clazz;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author FLY
 * @date 2019-12-14 16:06
 */
public class ReflectionMethods {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        //加载Class对象
        //会报出不存在该类的异常
        Class c=Class.forName("com.example.demo.test02.model.Student");

        //获取所有公共方法
        System.out.println("================获取所有公共方法=================");
        Method[] methods=c.getMethods();
        for (Method method:methods) {
            System.out.println("公共方法:"+method);
        }
        //获取所有方法
        System.out.println("================获取所有的方法=================");
        Method[] declaredMethods=c.getDeclaredMethods();
        for (Method declaredmethod:declaredMethods) {
            System.out.println("所有方法:"+declaredmethod);
        }

        System.out.println("================获取特定（带参）方法=================");
        Method method1=c.getMethod("method1",String.class);
        System.out.println("特定（带参）方法:"+method1);

        System.out.println("================获取特定（不带参）方法=================");
        Method method2=c.getDeclaredMethod("method2");
        System.out.println("特定（不带参）方法:"+method2);

        System.out.println("================获取特定（多参）方法=================");
        Method method3=c.getDeclaredMethod("method3", String.class, Integer.class, Date.class);
        System.out.println("特定（多参）方法:"+method3);
    }
}
