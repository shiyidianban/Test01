package com.example.demo.test01.thread;

import java.util.concurrent.*;

/**
 * @author FLY
 * @createdate 2019-12-12 15:05
 */
public class CallableAndFuture02 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
        for(int i = 1; i < 5; i++) {
            final int taskId = i;
            cs.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return taskId;
                }
            });
        }
        // 可能做一些事情
        for(int i = 1; i < 5; i++) {
            try {
                System.out.println(cs.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}
