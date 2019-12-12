package com.example.demo.test01.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author FLY
 * @Createdate 2019-12-12 17:31
 * @ProjectName Test01
 * @Desc com.example.demo.test01.thread
 */
public class ExecutorThreadPoolExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
                0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(512), // 使用有界队列，避免OOM
                new ThreadPoolExecutor.DiscardPolicy());
    }
}
