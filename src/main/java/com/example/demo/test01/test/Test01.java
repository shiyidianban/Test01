package com.example.demo.test01.test;

public class Test01 {
    String name = "a";

    String go() {
        return "- function in A";
    }

    public static void main(String[] args) {
        Test01 a = new B();
        System.out.println(a.name + a.go());
    }
}

class B extends Test01 {
    String name = "b";

    String go() {
        return "- function in B";
    }

}