package com.example.demo.test01.offer;

import java.util.LinkedHashMap;

/**
 * @author wu161 2018年8月27日下午1:52:40
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 思路：利用LinkedHashMap保存字符和出现次数。
 */
public class T35 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        char[] c = str.toCharArray();
        LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
        for (char item : c) {
            if (hash.containsKey(item))
                hash.put(item, hash.get(item) + 1);
            else
                hash.put(item, 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (hash.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
