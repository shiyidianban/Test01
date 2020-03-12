package com.example.demo.test;

import java.io.*;

/**
 * 找bug
 *
 * @author FLY
 * @date 2020-03-06 16:23
 */
public class Test15 {

    public static void main(String[] args) throws IOException {
        DataOutputStream dosDataOutputStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("data.txt")));
        byte b = 3;
        int i = 12;
        char ch = 'a';
        float f = 3.3f;
        dosDataOutputStream.write(b);
        dosDataOutputStream.writeInt(i);
        dosDataOutputStream.writeChar(ch);
        dosDataOutputStream.writeFloat(f);
        dosDataOutputStream.close();

        DataInputStream iDataInputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream("data.txt")));
        System.out.println(iDataInputStream.readByte());
        System.out.println(iDataInputStream.readInt());
        System.out.println(iDataInputStream.readChar());
        System.out.println(iDataInputStream.readFloat());
        iDataInputStream.close();
    }
}
