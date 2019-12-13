package com.example.demo.test01.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @Author FLY
 * @Createdate 2019-12-12 17:31
 * @ProjectName Test01
 * @Desc com.example.demo.test01.thread
 */
public class ExecutorThreadPoolExecutor {

    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(2, 3, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));
        //任务1
        pool.execute(new Runnable() {

            @SneakyThrows
            @Override
            public void run() {
                System.out.println("-------------helloworld_001---------------" + Thread.currentThread().getName());
            }
        });

/*        try {
            //主线程睡2秒
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----------hrm------------" + Thread.currentThread().getName());
            }
        });

        //任务2
        pool.execute(new Runnable() {

            @SneakyThrows
            @Override
            public void run() {
                System.out.println("-------------helloworld_002---------------" + Thread.currentThread().getName());
            }
        });

        // 任务3
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_003---------------" + Thread.currentThread().getName());
            }
        });

        // 任务4
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_004---------------" + Thread.currentThread().getName());
            }
        });

        // 任务5
        pool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("-------------helloworld_005---------------" + Thread.currentThread().getName());
            }
        });



        pool.shutdown();
    }
}
