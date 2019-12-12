package com.example.demo.test01.readObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author wu161 2018年12月18日下午9:48:49
 */
public class Test {


    public static void main(String[] args) {

//		DataInfo data = new DataInfo("S1","S2",3);
//		Test.writeObjectToFile(data);
        DataInfo data1 = (DataInfo) Test.readObjectFromFile();
        System.out.println(data1.getName());
    }

    public static void writeObjectToFile(Object obj) {
        File file = new File("E://test.dat");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
        }
    }

    public static Object readObjectFromFile() {
        Object temp = null;
        File file = new File("E://test.dat");
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(in);
            temp = objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
