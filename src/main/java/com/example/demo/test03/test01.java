package com.example.demo.test03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author FLY
 * @date 2020-03-24 20:11
 */
public class test01 {

    public static void main(String[] args) {
        String str = "cbacdcbc";

        char[] ch = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            }else{
                map.put(ch[i], 1);
            }
        }

        String s1 = "";
        for (int i = 0; i < ch.length; i++){
            if (map.get(ch[i]) == 1){
                s1 = s1 + ch[i];
            }else{
            }
        }

        System.out.println(s1);
    }
}
