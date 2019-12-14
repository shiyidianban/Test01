package com.example.demo.test01.thread;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @Author FLY
 * @Createdate 2019-12-12 16:15
 * @ProjectName Test01
 * @Desc com.example.demo.test01.thread
 */
public class ExecutorSingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {

                @SneakyThrows
                @Override
                public void run() {
                        System.out.println(index);
                }
            });
        }

        singleThreadExecutor.shutdown();
    }
}
