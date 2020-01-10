package com.example.demo.test02.model;

import java.util.Date;

/**
 * @author FLY
 * @date 2019-12-14 15:51
 */
public class Student {

    public String name;

    private Integer age;

    private Date Birthday;

    public Student(){

    }

    private Student(String name){
        this.name=name;
    }

    private Student(Integer age){
        this.age=age;
    }

    private Student(Date Birthday){
        this.Birthday=Birthday;
    }

    public Student(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    public Student(Integer age,String name){
        this.name=name;
        this.age=age;
    }

    public Student(String name,Date Birthday){
        this.name=name;
        this.Birthday=Birthday;
    }

    public Student(Date Birthday,String name){
        this.name=name;
        this.Birthday=Birthday;
    }

    public Student(Integer age,Date Birthday){
        this.age=age;
        this.Birthday=Birthday;
    }

    public Student(Date Birthday,Integer age){
        this.age=age;
        this.Birthday=Birthday;
    }

    public Student(String name,Integer age,Date Birthday){
        this.age=age;
        this.name=name;
        this.Birthday=Birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setSex(Date sex) {
        this.Birthday = Birthday;
    }

    public void method1(String str){
        System.out.println("public 修饰的方法");
    }

    private void method2(){
        System.out.println("private 修饰的方法");
    }

    String  method3(String name,Integer sex,Date age){
        System.out.println("默认修饰"+name+" "+sex+" "+age);
        return name+" "+sex+" "+age;
    }

    protected void method4(){
        System.out.println("protected 修饰的方法");
    }
}
