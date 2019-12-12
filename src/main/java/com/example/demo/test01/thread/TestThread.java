package com.example.demo.test01.thread;

/**
 * @author wu161 2018年9月10日上午10:15:23
 */
public class TestThread {

    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 600;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 50;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 50;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 50;

        // 盖伦攻击提莫
        while (!teemo.isDead()) {
            gareen.attackHero(teemo);
        }

        // 赏金猎人攻击盲僧
        while (!leesin.isDead()) {
            bh.attackHero(leesin);
        }
    }

}
