package com.example.demo.test02.lockTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author FLY
 * @date 2020-01-11 10:34
 */
@Slf4j
public class LockTest02 {

    private static volatile int finished = -1;

    private static volatile int id = 0;

    private static void checkFinished() {
        log.info(String.format("in checkFinished：%d", id));

        while (finished != id) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            id++;
        }

        log.info(String.format("out checkFinished：%d", id));
    }

    private static void finish() {

        finished = id;
        log.info(String.format("in finish：%d", finished));

    }

    public static void main(String[] args) throws InterruptedException {


        // 起一个线程检测是否结束
        new Thread(LockTest02::checkFinished, "01").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        finish();

        log.info("main finished");

    }
}
