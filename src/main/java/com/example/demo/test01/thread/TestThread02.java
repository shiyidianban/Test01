package com.example.demo.test01.thread;

/**
 * @author wu161 2018年9月10日上午10:15:23
 */
public class TestThread02 {

    public static void main(String[] args) throws InterruptedException {

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        // 匿名类
        Thread t1 = new Thread() {
            public void run() {
                // 匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                // 但是在JDK7以后，就不是必须加final的了

                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();


        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();

        Thread t3 = new Thread() {
            public void run() {
                if (!t1.isAlive()) {
                    t1.notify();
                    System.out.println("t1被唤醒");
                }
            }
        };
        t3.start();

        if (!t1.isInterrupted()) {
            t1.interrupt();
            System.out.println("t1被打断");
        }
    }

}
