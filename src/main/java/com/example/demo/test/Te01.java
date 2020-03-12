package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 笔试题
 *
 * @author FLY
 * @date 2020-02-18 12:34
 */
public class Te01 {

    public static void main(String[] args) {
        String test = "12345._";
        char[] t = test.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char i : t) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Character key = t[0];
        int num = map.get(key);
        for (Character i:map.keySet()){
            if (map.get(i) == num && i < key ){
                key = i;
            }else if (map.get(i) > num){
                num = map.get(i);
                key = i;
            }
        }

        if (key >= 97 && key <= 122){
            System.out.println(key);
        }

    }
}

