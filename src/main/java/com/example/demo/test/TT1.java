package com.example.demo.test;

/**
 * d
 *
 * @author FLY
 * @date 2020-06-14 22:19
 */
public class TT1 {

    public static void main(String[] args) {
        int m = 0;
        int count = 0;
        for (int i=0;i<=100;i++){
            m = m+1;
            count = ++count;
        }

        System.out.println(m*count);
    }
}
