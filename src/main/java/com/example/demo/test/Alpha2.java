package com.example.demo.test;

class Base {

    Base() {
        // TODO Auto-generated constructor stub
        System.out.println("Base");
    }

}

class Alpha2 extends Base {
    public static void main(String[] args) {
        new Alpha2();
        new Base();
    }
}


