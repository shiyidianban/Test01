package com.example.demo.test02.ioStream;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @Author FLY
 * @Createdate 2019-12-16 13:48
 * @ProjectName Test01
 * @Desc com.example.demo.test02.ioStream
 *
 * 管道媒介
 * 管道主要用来实现同一个虚拟机中的两个线程进行交流。因此，一个管道既可以作为数据源媒介也可作为目标媒介。
 * 需要注意的是java中的管道和Unix/Linux中的管道含义并不一样，
 * 在Unix/Linux中管道可以作为两个位于不同空间进程通信的媒介，
 * 而在java中，管道只能为同一个JVM进程中的不同线程进行通信。
 * 和管道相关的IO类为：PipedInputStream和PipedOutputStream，
 */
@Slf4j
public class IOTest05 {

    @SneakyThrows
    public static void main(String[] args) {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input  = new PipedInputStream(output);
        Thread thread1 = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    output.write( "Hello world, pipe!".getBytes());
                } catch (IOException e) {
                }
            }
        });
        Thread thread2 = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    int data = input.read();
                    while( data != -1){
                        System. out.print(( char) data);
                        data = input.read();
                    }
                } catch (IOException e) {
                } finally{
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }


}
