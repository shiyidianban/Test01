package com.example.demo.test02.lockTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author FLY
 * @date 2020-01-11 10:34
 */
@Slf4j
public class LockTest02 {

    private static int finished = 0;

    private static int id = 0;

    private static void checkFinished() {
        while (finished == 0) {
            id++;
        }

        log.info(String.format("finished：%d",id));
    }

    private static void finish() {
        finished = 1;
        log.info("finish-----------");

    }

    public static void main(String[] args) throws InterruptedException {
        // 起一个线程检测是否结束
        new Thread(LockTest02::checkFinished).start();

        Thread.sleep(1000);

        // 主线程将finished标志置为1
        finish();

        log.info("main finished");

    }
}
