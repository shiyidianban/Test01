package com.example.demo.test02.ioStream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author FLY
 * @Createdate 2019-12-16 13:48
 * @ProjectName Test01
 * @Desc com.example.demo.test02.ioStream
 *
 * File媒介
 */
public class IOTest04 {

    /**
     * File媒介
     */
    public static void fileDemo1(){
        //检查文件是否存在
        File file = new File( "d:/test.txt");
        boolean fileExists = file.exists();
        System. out.println( fileExists);
        //创建文件目录,若父目录不存在则返回false
        File file2 = new File( "d:/fatherDir/subDir");
        boolean dirCreated = file2.mkdir();
        System. out.println( dirCreated);
        //创建文件目录,若父目录不存则连同父目录一起创建
        File file3 = new File( "d:/fatherDir/subDir2");
        boolean dirCreated2 = file3.mkdirs();
        System. out.println( dirCreated2);
        File file4= new File( "d:/test.txt");
        //判断长度
        long length = file4.length();
        //重命名文件
        boolean isRenamed = file4.renameTo( new File("d:/test2.txt"));
        //删除文件
        boolean isDeleted = file4.delete();
        File file5= new File( "d:/fatherDir/subDir");
        //是否是目录
        boolean isDirectory = file5.isDirectory();
        //列出文件名
        String[] fileNames = file5.list();
        //列出目录
        File[]   files = file4.listFiles();
    }

    /**
     * 随机读取File文件
     * @throws IOException
     */
    public static void randomAccessFileRead() throws IOException {
        // 创建一个RandomAccessFile对象
        RandomAccessFile file = new RandomAccessFile( "d:/test.txt", "rw");
        // 通过seek方法来移动读写位置的指针
        file.seek(10);
        // 获取当前指针
        long pointerBegin = file.getFilePointer();
        // 从当前指针开始读
        byte[] contents = new byte[1024];
        file.read( contents);
        long pointerEnd = file.getFilePointer();
        System. out.println( "pointerBegin:" + pointerBegin + "\n" + "pointerEnd:" + pointerEnd + "\n" + new String(contents));
        file.close();
    }

    /**
     * 随机写入文件
     * @throws IOException
     */
    public static void randomAccessFileWrite() throws IOException {
        // 创建一个RandomAccessFile对象
        RandomAccessFile file = new RandomAccessFile( "d:/test.txt", "rw");
        // 通过seek方法来移动读写位置的指针
        file.seek(10);
        // 获取当前指针
        long pointerBegin = file.getFilePointer();
        // 从当前指针位置开始写
        file.write( "HELLO WORD".getBytes());
        long pointerEnd = file.getFilePointer();
        System. out.println( "pointerBegin:" + pointerBegin + "\n" + "pointerEnd:" + pointerEnd + "\n" );
        file.close();
    }
}
