package com.example.demo.test01.offer;

/**
 * @author wu161 2018年8月27日下午9:43:59
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s,输入n,打印出s的所有可能出现的概率
 * 思路：递归一般是自顶向下的分析求解，而循环则是自底向上，占用更少的空间和更少的时间，性能较好。
 * 定义一个二维数组，第一次掷骰子有6种可能，第一个骰子投完的结果存到probabilities[0]；第二次开始掷骰子，
 * 在下一循环中，我们加上一个新骰子，
 * 此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3, n-4,n-5，n-6的次数总和，
 * 所以我们把另一个数组的第n个数字设为前一个数组对应n-1,n-2,n-3,n-4,n-5，n-6之和
 */
public class T43 {

    public void printProbability(int number) {
        if (number < 1)
            return;
        int g_maxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[g_maxValue * number + 1];
        probabilities[1] = new int[g_maxValue * number + 1];
        int flag = 0;
        // 当第一次抛掷骰子时，有6种可能，每种可能出现一次
        for (int i = 1; i <= g_maxValue; i++)
            probabilities[0][i] = 1;
        // 从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        for (int k = 2; k <= number; ++k) {
            for (int i = 0; i < k; ++i)
                // 第k次掷骰子，和最小为k，小于k的情况是不可能发生的,令不可能发生的次数设置为0！
                probabilities[1 - flag][i] = 0;
            // 第k次掷骰子，和最小为k，最大为g_maxValue*k
            for (int i = k; i <= g_maxValue * k; ++i) {
                // 初始化，因为这个数组要重复使用，上一次的值要清0
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; ++j)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.println(i);
            System.out.println(ratio);
        }
    }

    public static void main(String[] args) {
        T43 t = new T43();
        t.printProbability(1);

    }

}
