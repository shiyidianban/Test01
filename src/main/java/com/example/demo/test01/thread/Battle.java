package com.example.demo.test01.thread;

/**
 * @author wu161 2018年9月10日上午10:15:23
 */
public class Battle implements Runnable {

    private Hero h1;
    private Hero h2;

    public Battle(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run() {
        while (!h2.isDead()) {
            h1.attackHero(h2);
        }
    }

    public static void main(String[] args) {

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

        Battle battle1 = new Battle(gareen, teemo);

        new Thread(battle1).start();

        Battle battle2 = new Battle(bh, leesin);
        new Thread(battle2).start();

    }

}