package com.example.demo.test02.lockTest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FLY
 * @date 2020-01-10 15:50
 */
@Slf4j
@Data
public class LockTest01 implements Runnable {

    private String name;

    private static int id = 0;

    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        testVolatile();
    }

    private static synchronized void testVolatile() {

        for (int i = 0; i < 10000; i++) {
            id = id + 1;
        }
        log.info(String.format("当前时间：%s：%s，当前线程：%s，id = %d",
                System.currentTimeMillis(),
                System.nanoTime(),
                Thread.currentThread().getName(),
                id));
    }

    private static void test() {
        long l1 = System.nanoTime();
        lock.lock();
        try {
            log.info(String.format("开始时间：%s：%s，当前线程：%s", System.currentTimeMillis(), System.nanoTime(), Thread.currentThread().getName()));
//            Thread.sleep(1000);
            log.info(String.format("结束时间：%s：%s，当前线程：%s", System.currentTimeMillis(), System.nanoTime(), Thread.currentThread().getName()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void testLocK() {
        long m1 = System.currentTimeMillis();
        log.info(String.format("-----开始时间：%s：%s，当前线程：%s", m1, System.nanoTime(), Thread.currentThread().getName()));
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 50; i++) {
            LockTest01 test01 = new LockTest01();
            test01.setName("tes01");
            Thread t1 = new Thread(test01);
            executor.execute(t1);
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                log.info("所有的子线程都结束了！");
                break;
            }
        }
        long m2 = System.currentTimeMillis();
        log.info(String.format("-----结束时间：%s：%s，当前线程：%s", m2, System.nanoTime(), Thread.currentThread().getName()));
        log.info(String.format("-----使用时间：%s：%s，当前线程：%s", m2 - m1, System.nanoTime(), Thread.currentThread().getName()));
    }

    public static void main(String[] args) {

        testLocK();

    }

}
