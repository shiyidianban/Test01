package com.example.demo.test02.ioStream;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @Author FLY
 * @Createdate 2019-12-16 13:48
 * @ProjectName Test01
 * @Desc com.example.demo.test02.ioStream
 */
@Slf4j
public class IOTest03 {

    @SneakyThrows
    public static void main(String[] args) {
        writeByteToFile();
    }


    /**
     * 用字节流写文件
     *
     * @throws IOException
     */
    public static void writeByteToFile() throws IOException {
        String hello = new String("hello word!");
        byte[] byteArray = hello.getBytes();
        File file = new File("C:\\Users\\Q\\test.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        //因为是用字节流来写媒介，所以对应的是OutputStream
        //又因为媒介对象是文件，所以用到子类是FileOutputStream
        OutputStream os = new FileOutputStream(file);
        os.write(byteArray);
        os.close();
    }

    /**
     * 用字节流读文件
     *
     * @throws IOException
     */
    public static void readByteFromFile() throws IOException {
        File file = new File("C:\\Users\\Q\\test.txt");
        byte[] byteArray = new byte[(int) file.length()];
        //因为是用字节流来读媒介，所以对应的是InputStream
        //又因为媒介对象是文件，所以用到子类是FileInputStream
        InputStream is = new FileInputStream(file);
        int size = is.read(byteArray);
        System.out.println("大小:" + size + ";内容:" + new String(byteArray));
        is.close();
    }

    /**
     * 用字符流读文件
     *
     * @throws IOException
     */
    public static void writeCharToFile() throws IOException {
        String hello = new String("hello word!");
        File file = new File("C:\\Users\\Q\\test.txt");
        //因为是用字符流来读媒介，所以对应的是Writer，又因为媒介对象是文件，所以用到子类是FileWriter
        Writer os = new FileWriter(file);
        os.write(hello);
        os.close();
    }

    /**
     * 用字符流写文件
     *
     * @throws IOException
     */
    public static void readCharFromFile() throws IOException {
        File file = new File("C:\\Users\\Q\\test.txt");
        //因为是用字符流来读媒介，所以对应的是Reader
        //又因为媒介对象是文件，所以用到子类是FileReader
        Reader reader = new FileReader(file);
        char[] byteArray = new char[(int) file.length()];
        int size = reader.read(byteArray);
        System.out.println("大小:" + size + ";内容:" + new String(byteArray));
        reader.close();
    }

    /**
     * 字节流转换为字符流
     * @throws IOException
     */
    public static void convertByteToChar() throws IOException{
        File file= new File( "C:\\Users\\Q\\test.txt");
        //获得一个字节流
        InputStream is= new FileInputStream( file);
        //把字节流转换为字符流，其实就是把字符流和字节流组合的结果。
        Reader reader= new InputStreamReader( is);
        char [] byteArray= new char[( int) file.length()];
        int size= reader.read( byteArray);
        System. out.println( "大小:"+size +";内容:" +new String(byteArray));
        is.close();
        reader.close();
    }

    /**
     * BufferedInputStream顾名思义，
     * 就是在对流进行写入时提供一个buffer来提高IO效率。
     * 在进行磁盘或网络IO时，原始的InputStream对数据读取的过程都是一个字节一个字节操作的，
     * 而BufferedInputStream在其内部提供了一个buffer，在读数据时，会一次读取一大块数据到buffer中，
     * 这样比单字节的操作效率要高的多，特别是进程磁盘IO和对大量数据进行读写的时候。
     * 使用BufferedInputStream十分简单，只要把普通的输入流和BufferedInputStream组合到一起即可。

     * @throws IOException
     */
    public static void readByBufferedInputStream() throws IOException {
        File file = new File( "d:/test.txt");
        byte[] byteArray = new byte[( int) file.length()];
        //可以在构造参数中传入buffer大小
        InputStream is = new BufferedInputStream( new FileInputStream(file),2*1024);
        int size = is.read( byteArray);
        System.out.println( "大小:" + size + ";内容:" + new String(byteArray));
        is.close();
    }

}
