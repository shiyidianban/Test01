package com.example.demo.test01.test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author wu161
 * 给定两个数R和n，输出R的n次方，其中0.0<R<99.999, 0<n<=25
 * 多组测试用例，请参考例题的输入处理 输入每行一个浮点数 R 其中0.0 < R <99.999， 一个整数 n 其中0 < n <=25
 */
public class Test17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String R = scanner.next();
        int n = scanner.nextInt();
        BigDecimal bigDecimal = new BigDecimal(R);
        while (--n > 0) {
            bigDecimal = bigDecimal.multiply(new BigDecimal(R));
        }
        System.out.println(bigDecimal.stripTrailingZeros().toPlainString());
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
