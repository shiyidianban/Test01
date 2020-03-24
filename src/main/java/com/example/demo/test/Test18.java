package com.example.demo.test;

import java.math.BigInteger;
import java.util.*;


public class Test18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        Map<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        while(n != null){
            map.put(n.split(" ")[1],n.split(" ")[0]);
            set.add(n.split(" ")[0]);
            set.add(n.split(" ")[1]);
            n = sc.nextLine();
        }

        String s = (String) set.toArray()[2];
        int[][] num = new int[set.size()][set.size()];
        for (int i = 0 ; i < num.length ; i++){
            for (int j = i ; j < num.length ; j++){

            }
        }
    }

}