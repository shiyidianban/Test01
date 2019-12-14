package com.example.demo.test02.clazz;

import java.lang.reflect.Constructor;
import java.util.Date;

/**
 * @Author FLY
 * @Createdate 2019-12-14 15:52
 * @ProjectName Test01
 * @Desc com.example.demo.test02.clazz
 */
public class ReflectionConstructor {

    public static void main(String[] args) throws ClassNotFoundException,NoSuchMethodException{

        //加载Class对象
        //会报出不存在该类的异常
        Class c=Class.forName("com.example.demo.test02.model.Student");

        //获取所有公用构造方法
        System.out.println("================获取所有公共的构造方法=================");
        Constructor[] constructors=c.getConstructors();
        for (Constructor constructor:constructors) {
            System.out.println("公共的构造方法:"+constructor);
        }
        //获取所有构造方法
        System.out.println("================获取所有的构造方法=================");
        Constructor[] declaredconstructors=c.getDeclaredConstructors();
        for (Constructor constructor:declaredconstructors) {
            System.out.println("所有构造方法:"+constructor);
        }

        //获取公有&无参构造方法
        System.out.println("================获取公有&无参构造方法=================");

        //会报出没有该方法的异常
        Constructor constructor1=c.getConstructor(null);
        System.out.println("公有&无参构造方法:"+constructor1);

        //获取公有&有参构造方法
        System.out.println("================获取公有&有参构造方法=================");

        //会报出没有该方法的异常
        Constructor constructor2=c.getConstructor(new Class[]{String.class,Integer.class, Date.class});
        System.out.println("公有&有参构造方法:"+constructor2);
        Constructor constructor3=c.getConstructor(new Class[]{String.class,Integer.class});
        System.out.println("公有&有参构造方法:"+constructor3);

        //获取私有&有参构造方法
        System.out.println("================获取私有&有参构造方法=================");

        //会报出没有该方法的异常
        Constructor declaredconstructor1=c.getDeclaredConstructor(new Class[]{String.class});
        System.out.println("私有&有参构造方法:"+declaredconstructor1);
    }
}
