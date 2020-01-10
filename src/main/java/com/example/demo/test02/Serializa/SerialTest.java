package com.example.demo.test02.Serializa;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author FLY
 * @date 2019-12-17 13:57
 */
public class SerialTest {

    @SneakyThrows
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        //序列化
        User1 user = new User1("陈本布衣", "123456", 100);
        Menu menu = new Menu(1,"菜单1","/menu1");
        user.setMenu(menu);
        System.out.println("当前时间："+new Date());
        System.out.println(user);
        List<Menu> menus = new ArrayList<>();
        menus.add(menu);
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user"))) {
            os.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //先睡5秒
        TimeUnit.SECONDS.sleep(5);

        //反序列化
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("user"))) {
            User1 o = (User1) is.readObject();
            System.out.println("当前时间："+new Date());
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Menu implements Serializable{
    private Integer id;
    private String name;
    private String url;

    public Menu() {
    }

    public Menu(Integer id,String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

class User1 implements Serializable {

    private static final long serialVersionUID = -1075318199295234057L;

    //时间标示
    private Date date = new Date();

    private String name;

    private Menu menu;

    private transient String password;

    private int age;

    public User1() {
    }

    public User1(String name, String password, int age) {
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }


    @Override
    public String toString() {
        return "User{" +
                "序列化存储时间：" + date +
                ", name='" + name + '\'' +
                ", 菜单：" + menu.toString() +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}