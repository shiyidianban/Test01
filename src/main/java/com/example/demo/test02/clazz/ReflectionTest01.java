package com.example.demo.test02.clazz;

import com.example.demo.test02.model.ReflectionModel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author FLY
 * @date 2019-12-14 14:14
 */
@Slf4j
public class ReflectionTest01 {

    @SneakyThrows
    public static void main(String[] args) {
        ReflectionModel rModel = new ReflectionModel();
        //通过反射机制创建class对象（三种方法）
        Class class1 = Class.forName("com.example.demo.test02.model.ReflectionModel");
        Class class2 = rModel.getClass();
        Class class3 = ReflectionModel.class;

        log.info(class1.getName());
        //打印父类的信息
        log.info(class1.getSuperclass().getName());

        //创建一个新的对象
        ReflectionModel rModel1 = (ReflectionModel) class1.newInstance();
        log.info("打印所有属性{}", rModel1.toString());

        // 返回声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        Method[] methods = class1.getDeclaredMethods();
        for (Method m : methods) {
            log.info("返回声明的所有方法：{}", m.getName());
        }

        //返回可被访问的公共方法
        Method[] methods2 = class1.getMethods();
        for (Method m : methods2) {
            log.info("返回可被访问的公共方法：{}", m.getName());
        }

        //返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段。 包括公共、私有、保护的字段。
        Field[] field = class1.getDeclaredFields();
        for (Field m : field) {
            log.info("返回可被访问属性：{}，{}", m.getName(),m.getGenericType());
        }
    }

}
