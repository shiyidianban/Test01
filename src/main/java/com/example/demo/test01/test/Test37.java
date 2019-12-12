package com.example.demo.test01.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wu161 2018年9月17日下午3:12:23
 */
public class Test37 {

    public static List list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] result = new int[n - 1];
        String[] source = new String[n];
        for (int i = 0; i < source.length; i++) {
            source[i] = String.valueOf(i + 1);
        }
        getResult(0, result, source, m);
        System.out.println(list.size());
    }

    //使用递归求出3^8种情况  
    public static void getResult(int index, int[] result, String[] source, int m) {
        if (index == result.length) {
            showResult(result, source, m);//根据数组的取值转换成表达式，且求值，这方法有待改进，写的很乱
            return;
        }
        //每个空有三种可能，0,1,2  
        for (int i = 0; i < 3; i++) {
            result[index] = i;
            getResult(index + 1, result, source, m);
            result[index] = 0; //恢复原来的状态
        }
    }

    public static void showResult(int[] result, String[] source, int m) {

        int sum = 0;
        //默认在第一个数字，即1之前是"+"号，方便编程而已  
        char operateChar = '+';
        //String[] source=new String[]{"1","2","3","4","5","6","7","8","9"};
        //最终的表达式，最好用StringBuilder，在非多线程的情况下，字符串拼接的性能，StringBuilder最好，  
        //当然用StringBuffer或者单纯的String也可以  
        StringBuilder expression = new StringBuilder();
        //用于记录临时的数字，因为参与运算的数字可能是几位的数字，所以也需要拼接  
        StringBuilder number = new StringBuilder();
        //先加入第一个字符，即1  
        number.append(source[0]);

        expression.append(source[0]);

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {//如果为0，表示数字合并
                number.append(source[i + 1]);
                expression.append(source[i + 1]);
            } else if (result[i] == 1) {
                sum = calc(operateChar, sum, number);
                operateChar = '+';
                number.append(source[i + 1]);
                expression.append("+").append(source[i + 1]);
            } else if (result[i] == 2) {
                sum = calc(operateChar, sum, number);
                operateChar = '-';
                number.append(source[i + 1]);
                expression.append("-").append(source[i + 1]);
            }
        }
        sum = calc(operateChar, sum, number);
        if (sum == m) {
//            System.out.print(expression.toString()+"="+m);  
//            System.out.println();
            list.add(expression.toString() + "=" + m);
        }
    }

    public static int calc(char operateChar, int sum, StringBuilder number) {
        if (operateChar == '+') {
            sum += Integer.parseInt(number.toString());
            number.delete(0, number.length());
        } else if (operateChar == '-') {
            sum -= Integer.parseInt(number.toString());
            number.delete(0, number.length());
        }
        return sum;
    }

}  
