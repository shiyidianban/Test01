package com.example.demo.test02.Serializa;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Date;

/**
 * @author FLY
 * @date 2019-12-17 13:57
 */
public class SerialDemo {

    @SneakyThrows
    public static void main(String[] args) throws IOException,ClassNotFoundException{

        FileOutputStream fos =new FileOutputStream("object.out");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        User user1 = new User("陈本布衣", "123456", 100);
        System.out.println("当前时间："+user1.getDate());
        System.out.println(user1.toString());
        oos.writeObject(user1);
        oos.flush();
        oos.close();

        Thread.sleep(5000);

        FileInputStream fis=new FileInputStream("object.out");
        ObjectInputStream ois=new ObjectInputStream(fis);
        User user2=(User) ois.readObject();
        System.out.println("当前时间："+new Date());
        System.out.println(user2.toString());
    }
}

class User implements Serializable {

    private static final long serialVersionUID = -1075318199295234057L;

    //时间标示
    private Date date = new Date();

    private String name;

    private transient String password;

    private int age;

    public User() {
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "序列化存储时间：" + date +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}