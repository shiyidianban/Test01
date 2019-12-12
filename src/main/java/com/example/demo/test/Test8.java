package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

public class Test8 {

    public int[] method(int array[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], 1);
        }
        int[] arrasy = new int[map.size()];
        int i_ = 0;
        for (int i : map.keySet()) {
            arrasy[i_] = i;
            i_++;
        }
        return arrasy;
    }
}