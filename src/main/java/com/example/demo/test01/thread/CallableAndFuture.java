package com.example.demo.test01.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author FLY
 * @createdate 2019/12/12 15:03
 */
public class CallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });

        System.out.println(future.get());
        threadPool.shutdown();
    }
}
