package com.example.demo.test01.test;

import java.util.Scanner;

public class Test27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String m = sc.nextLine();
        int[] arrayN = new int[2];
        arrayN[0] = Integer.valueOf(n.split(",")[0]);
        arrayN[1] = Integer.valueOf(n.split(",")[1]);
        int arrayNx = arrayN[0] * arrayN[0] + arrayN[1] * arrayN[1];
        int[][] arrayM = new int[m.split(",").length / 2][2];
        int[] arrayMx = new int[m.split(",").length / 2];
        for (int i = 0; i < arrayM.length; i++) {
            arrayM[i][0] = Integer.valueOf(m.split(",")[2 * i]);
            arrayM[i][1] = Integer.valueOf(m.split(",")[2 * i + 1]);
            arrayMx[i] = arrayM[i][1] * arrayM[i][1] + arrayM[i][0] * arrayM[i][0];
        }
        int i = 0;
        boolean flase = false;
        for (i = 0; i < arrayMx.length; i++) {
            if (arrayNx <= arrayMx[i]) {
                flase = true;
                break;
            }
        }
        if (flase) {
            System.out.println("yes,0");
            return;
        }
        int x = arrayN[0] - arrayM[0][0] + arrayN[1] - arrayM[0][1];
        for (i = 0; i < arrayM.length; i++) {
            int l = 0;
            if (arrayN[0] - arrayM[i][0] != 0 && arrayN[1] - arrayM[i][1] != 0)
                l = arrayN[0] - arrayM[i][0] + arrayN[1] - arrayM[i][1];
            else if (arrayN[0] - arrayM[i][0] == 0)
                l = arrayN[1] - arrayM[i][1];
            else if (arrayN[1] - arrayM[i][1] == 0)
                l = arrayN[0] - arrayM[i][0];
            if (l < x) {
                x = l;
            }
        }
        System.out.println("no," + x);
    }

    //2,2
    //0,0,0,2,2,2,2,0
}