package com.example.demo.test01.test;

import java.util.Scanner;

public class Test03 {
    public static String minpath = "asdasd";

    static {
        System.out.println("Test3Test3");
    }

    public Test03() {
        super();
        System.out.println("Test3构造函数");
    }
	
	
    
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine().trim());
		Point[] points = new Point[num];
		for (int i = 0; i < num; i++) {
			String[] locations = sc.nextLine().trim().split(",");
			points[i] = new Test3().new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
		}
		dfs(new Test3().new Point(0, 0), points, 0, 0);
		System.out.println(minpath);
	}
 
	public static void dfs(Point start, Point[] points, int sum, int count) {
		if (count == points.length) {
			sum += start.getLength(new Test3().new Point(0, 0));// 回到起点
			if (sum < minpath) {
				minpath = sum;
			}
			return;
		}
 
		for (int i = 0; i < points.length; i++) {
			if (!points[i].isVisited) {
				points[i].isVisited = true;// 访问
				dfs(points[i], points, sum + start.getLength(points[i]), count + 1);
				points[i].isVisited = false;// 未访问
			}
		}
 
	}
 
	class Point {
		int x, y;
		boolean isVisited;
 
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.isVisited = false;
		}
 
		public int getLength(Point point) {
			return Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
		}
	}*/
}