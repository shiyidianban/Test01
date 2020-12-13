package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

public class Test21 {

    private static boolean valid(String word, String abbr) {
        char[] chars = word.toCharArray();
        char[] abbrChars = abbr.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder("0");
        int position = 0;
        for (int i = 0; i < abbrChars.length; i++) {
            if (Character.isDigit(abbrChars[i])) {
                stringBuilder.append(abbrChars[i]);
            } else {
                map.put(position, Integer.valueOf(stringBuilder.toString()));
                stringBuilder = new StringBuilder("0");
                position = i;
            }
        }

        map.put(position, Integer.valueOf(stringBuilder.toString()));
        for (Integer key : map.keySet()) {
            if (chars[0] != abbrChars[key]) {
                return false;
            }

            Integer integer = map.get(key);
            if (integer != 0) {
                word = word.replace(word.substring(0, integer + 1), "");
            } else {
                word = word.substring(1);
            }

            chars = word.toCharArray();
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "apple", abbr = "a2e";
        System.out.println(valid(s, abbr));
    }
}