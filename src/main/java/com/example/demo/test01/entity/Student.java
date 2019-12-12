package com.example.demo.test01.entity;

/**
 * @author wu161
 * 2018年8月19日上午10:56:58
 */
public class Student {

    private int age;

    public boolean equals(Student s) {

        return age > s.getAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
