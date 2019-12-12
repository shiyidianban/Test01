package com.example.demo.test01.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author FLY
 * @createdate 2019/12/12 14:47
 */
public class CallableDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Double> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask, "aaa").start();

        //同一个任务只会执行一次,重启一个线程执行相同的task,不会进去任务
        new Thread(futureTask, "bbb").start();
        System.out.println(Thread.currentThread().getName() + "正在执行");

        //如果非要task的返回值;
        //类似自旋锁;,做完跳出循环,获得callable的值;
        while (!futureTask.isDone()) {

        }

        int i = 0;
        //get是阻塞的方法,一般放在最后执行
        System.out.println("resutl:" + (i + futureTask.get()));
    }
}

class MyThread implements Callable<Double> {

    @Override
    public Double call() {
        try {
            System.out.println(Thread.currentThread().getName() + "正在执行");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("call");
        } catch (InterruptedException e) {
            e.printStackTrace();
            //futuretask的get方法也可以接受到处理异常的 返回信息;
            return 4444.9;
        }

        return 555.9;
    }

}