package com.example.demo.test02.clazz;

/**
 * @author FLY
 * @date 2019-12-16 18:54
 */
public class InitiativeUse {

    static {
        System.out.println("InitiativeUse静态代码块");
    }

    public static void main(String[] args) {
        YeYe son = new YeYe();
        System.out.println(son);
    }
}

class YeYe {
    static {
        System.out.println("YeYe静态代码块");
    }
}

class Father extends YeYe {
    public final static String strFather = "HelloJVM_Father";

    {
        System.out.println("Father动态代码块");
    }

    static {
        System.out.println("Father静态代码块");
    }
}

class Son extends Father {
    public final static String strSon = "HelloJVM_Son";

    static {
        System.out.println("Son静态代码块");
    }
}