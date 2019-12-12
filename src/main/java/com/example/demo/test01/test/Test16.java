package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161 小招喵喜欢在数轴上跑来跑去，假设它现在站在点n处，它只会3种走法，分别是： 1.数轴上向前走一步，即n=n+1
 * 2.数轴上向后走一步,即n=n-1 3.数轴上使劲跳跃到当前点的两倍，即n=2*n
 * 现在小招喵在原点，即n=0，它想去点x处，快帮小招喵算算最快的走法需要多少步？
 */
public class Test16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, result;
        x = sc.nextInt();
        if (x < 0) {
            result = jump_count(-x);
        } else {
            result = jump_count(x);
        }
        System.out.println(result);
    }

    static int jump_count(int x) {
        int count, result = 0, num;
        if (x <= 3)
            result = x;
        if (x > 3) {
            count = 0;
            num = x;
            while (num > 3) {
                if (num % 2 == 0) {
                    num = num / 2;
                    count++;
                } else {
                    if ((num + 1) / 2 % 2 == 0 && (num - 1) / 2 % 2 != 0)
                        num = (num + 1) / 2;
                    else
                        num = (num - 1) / 2;
                    count += 2;
                }
            }
            result = count + num;
        }
        return result;
    }
}
