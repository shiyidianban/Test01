package com.example.demo.test01.test;

import java.util.Scanner;

/**
 * @author wu161 2018年9月17日下午8:06:57
 */
public class Test40 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[][] array = new String[n][3];
        for (int i = 0; i < n; i++) {
            array[i][0] = String.valueOf(scan.nextInt());
            array[i][1] = String.valueOf(scan.nextInt());
            array[i][2] = String.valueOf(scan.nextInt());
        }

        for (int i = 0; i < n; i++) {
            long n4 = get(Integer.valueOf(array[i][0]), Long.valueOf(array[i][1]), Long.valueOf(array[i][2]));
            System.out.println(n4);
        }

    }

    public static long get(int k, long l, long r) {
        String n1;
        String n3 = String.valueOf(digits[k - 1] - '0');
        String[] n2;
        long count = 0;
        long max = 0;
        long max_j = 0;
        for (long j = l; j < r; j++) {
            n1 = TenTransToN(j, k);
            n2 = n1.split("");
            count = 0;
            for (int i = 0; i < n2.length; i++) {
                if (n3.equals(n2[i])) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                max_j = j;
            }
        }
        return max_j;
    }

    static String TenTransToN(long val, int radix) {

        long temp = val;
        int len = 1; //目标进制的字符串长度
        while (temp >= radix) {
            temp = temp / radix;
            len++;
        }

        char[] buf = new char[len];
        formatLong(buf, val, radix, len);

        return new String(buf);
    }

    static void formatLong(char[] buf, long val, int radix, int len) {
        long temp;
        long radixPow;
        int charPos = len;
        --len;
        while (charPos != 0) {

            radixPow = (long) Math.pow(radix, --charPos);
            temp = val;
            if (val >= radixPow) {
                val = temp % radixPow;
                buf[len - charPos] = digits[(int) (temp / radixPow)];
            } else {
                buf[len - charPos] = '0';
            }
        }
    }

    static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g'
    };
}
