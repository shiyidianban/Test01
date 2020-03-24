package com.example.demo.test;

import java.util.Scanner;

public class Test16 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] nums1 = n.split("/");
        String path = "";
        for (int i = nums1.length - 1 ; i > 0; i--) {
            if ("..".equals(nums1[i])){
                i = i - 2;
            }

            if (!".".equals(nums1[i]))
                path = "/" + nums1[i] + path;
        }

        System.out.println(path);
    }
}
