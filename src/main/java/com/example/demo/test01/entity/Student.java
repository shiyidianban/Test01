package com.example.demo.test01.entity;

import com.example.demo.test01.offer.T03;

/**
 * @author wu161
 * 2018年8月19日上午10:56:58
 */
public class Student extends T03 {

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

    public boolean find(int[][] array, int target){
        return true;
    }

}
