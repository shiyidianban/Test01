package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wu161 2018年9月26日下午7:41:56
 */
public class asd {

    public static void main(String args[]) {
		/*Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());
		List<String[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] sa= scanner.nextLine().split(" ");
			list.add(sa);
		}
		int max = 0;
		int count = 0;
		for(int i = 0 ; i < list.size() ; i++) {
			Set<String> set = new HashSet<>(Arrays.asList(list.get(i)));
			int cout2 = 1;
			for(int j = i+1 ; j<list.size(); j++) {
				if(isTreu(list.get(j), set)) {
					cout2++;
					for (int k = 0; k < list.get(j).length; k++) {
						set.add(list.get(j)[k]);
					}
				}
			}
			if(set.size() > max) {
				max = set.size(); 
				count = cout2;
			}
		}
		System.out.println(count);
		System.out.println(max);*/
//		String s = "	dadsa  ".replaceAll("\\s*", "");
//		System.out.println(s);
        System.out.println(100 >> 2);
        System.out.println(1 << 4);
        System.out.println(1 << 30);
    }

    public static boolean isTreu(String[] arr, Set<String> set) {
        for (int k = 0; k < arr.length; k++) {
            if (set.contains(arr[k]))
                return true;
        }
        return false;
    }
}
