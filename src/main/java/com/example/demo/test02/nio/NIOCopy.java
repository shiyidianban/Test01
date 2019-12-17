package com.example.demo.test02.nio;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author FLY
 * @Createdate 2019-12-17 11:04
 * @ProjectName Test01
 * @Desc com.example.demo.test02.nio
 * 拷贝文件
 */
public class NIOCopy {

    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\Q\\test.txt";
        String outPath = "C:\\Users\\Q\\test1.txt";
        copyFileUseNIO(inPath,outPath);
    }

    /**
     * 用java NIO api拷贝文件
     * @param src
     * @param dst
     * @throws IOException
     */
    public static void copyFileUseNIO(String src,String dst) throws IOException {
        //声明源文件和目标文件
        FileInputStream fi=new FileInputStream(new File(src));
        FileOutputStream fo=new FileOutputStream(new File(dst));
        //获得传输通道channel
        FileChannel inChannel=fi.getChannel();
        FileChannel outChannel=fo.getChannel();
        //获得容器buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while(true){
            //判断是否读完文件
            int eof =inChannel.read(buffer);
            if(eof==-1){
                break;
            }
            //重设一下buffer的position=0，limit=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }

        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
    }

    @SneakyThrows
    public static void readFile(){

        FileInputStream fin = new FileInputStream( "readandshow.txt" );
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );
        fc.read( buffer );
    }
}
