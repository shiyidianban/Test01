package com.example.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test01 {

    public void sdf() {

    }

    public int sdf(int i) {
        return 0;
    }

    public static void main(String[] args) {
		/*Map map = new HashMap<>();
		Collections.sort(new ArrayList());
		System.out.println(1 << 30);*/

        int count = 0;
        int x = 2015;
        while (x != 0) {
            count++;
            //下面的输出是为了便于查看
            System.out.println(x + "," + Integer.toBinaryString(x));
            x = x & (x - 1);
        }
        System.out.println("原来x中的1的个数为：" + count);
        String g = "as";
        StringBuffer a = new StringBuffer();
        StringBuilder a1 = new StringBuilder();
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Long[] arr = new Long[n];
		for (int i = 0; i < n; i++)
			arr[i] = (long) sc.nextInt();
		sc.close();
		long max = 0;
		long last = 0;
		long frist = 0;

		frist = 0;
		for (int j = 0, k = n - 1; j < k; j++) {
			last = last + arr[k];
			frist = frist + arr[j];
			if (frist == last) {
				max = last;
				k--;
			} else if (frist > last) {
				k--;
			} else if (frist < last)
				last = last - arr[k];
		}

		System.out.println(max);*/
    }
}