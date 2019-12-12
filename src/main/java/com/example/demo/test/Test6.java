package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().split("=")[1].replaceAll("\"", "");
        String line2 = scanner.nextLine().split("=")[1];
        Set<String> dict = new HashSet<>(Arrays.asList(line2.replaceAll("\"", "").split(",")));
        List s1 = wordBreak(s, dict);
        if (res.size() == 0) {
            System.out.println("");
        } else {
            System.out.print(res.toString());
        }
    }

    public static List<String> res = new LinkedList<String>();

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            // 只在单词的后一个字母开始寻找，否则跳过
            if (dp[i] == null) continue;
            // 看从当前字母开始能组成哪个在字典里的词
            for (String word : wordDict) {
                int len = word.length();
                if (i + len > s.length()) continue;
                String sub = s.substring(i, i + len);
                if (word.equals(sub)) {
                    if (dp[i + len] == null) {
                        dp[i + len] = new ArrayList<String>();
                    }
                    dp[i + len].add(word);
                }
            }
        }
        // 如果数组末尾不存在单词，说明找不到分解方法
        if (dp[s.length()] != null) backTrack(dp, s.length(), new ArrayList<String>());
        return res;
    }

    private static void backTrack(List<String> dp[], int end, ArrayList<String> tmp) {
        if (end <= 0) {
            String path = tmp.get(tmp.size() - 1);
            for (int i = tmp.size() - 2; i >= 0; i--) {
                path += " " + tmp.get(i);
            }
            res.add(path);
            return;
        }
        for (String word : dp[end]) {
            tmp.add(word);
            backTrack(dp, end - word.length(), tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}