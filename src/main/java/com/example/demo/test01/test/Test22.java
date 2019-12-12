package com.example.demo.test01.test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author wu161 2018年8月30日上午10:00:36
 * 给定两个数R和n，输出R的n次方，其中0.0<R<99.999, 0<n<=25
 */

public class Test22 {
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
}