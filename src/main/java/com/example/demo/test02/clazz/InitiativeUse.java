package com.example.demo.test02.clazz;

/**
 * @Author FLY
 * @Createdate 2019-12-16 18:54
 * @ProjectName Test01
 * @Desc com.example.demo.test02.clazz
 */
public class InitiativeUse {
    public static void main(String[] args) {
        System.out.println(Son.strSon);
    }
}

class YeYe {
    static {
        System.out.println("YeYe静态代码块");
    }
}

class Father extends YeYe {
    public final static String strFather = "HelloJVM_Father";

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