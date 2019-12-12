package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月26日下午12:55:35
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class T09_4 {

    public int JumpFloor2(int target) {
        return (int) Math.pow(2, target - 1);
    }

}
