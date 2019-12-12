package com.example.demo.test;

class X {

    Y b = new Y();

    public static String x = "asd";

    X() {
        System.out.println("X");
    }

    static {
        System.out.println("staticX");
    }

    {
        System.out.println("X2");
    }
}

class Y {


    Y() {
        System.out.println("Y");
    }

    static {
        System.out.println(X.x);
        System.out.println("staticY");
    }

    {
        System.out.println("Y2");
    }

}

public class Test3 extends X {

    Y y = new Y();

    static {
        System.out.println("staticTest3");
    }

    {
        System.out.println("Test32");
    }

    Test3() {
        System.out.println("Z");
    }

    public static void main(String args[]) {
        new Test3();
    }
}