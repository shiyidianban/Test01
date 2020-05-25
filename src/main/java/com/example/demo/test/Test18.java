package com.example.demo.test;

public class Test18 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String n = sc.nextLine();
//        Map<String,String> map = new HashMap<>();
//        Set<String> set = new HashSet<>();
//        while(n != null){
//            map.put(n.split(" ")[1],n.split(" ")[0]);
//            set.add(n.split(" ")[0]);
//            set.add(n.split(" ")[1]);
//            n = sc.nextLine();
//        }
//
//        String s = (String) set.toArray()[2];
//        int[][] num = new int[set.size()][set.size()];
//        for (int i = 0 ; i < num.length ; i++){
//            for (int j = i ; j < num.length ; j++){
//
//            }
//        }
        System.out.println(4.0 - 3.6);
        ok:

        for (int i = 0; i < 10; i++) {
            System.out.println("i");
            for (int j = 0; j < 10; j++) {
                System.out.println("j");
                break ok;
            }

            System.out.println(test());
        }

    }

    public static int test() {
        int i = 0;
        try {
            System.out.println("1");
            i = 1;
            if (i != 3) {
                throw new Exception("错误信息");
            }

//            return i;

        } catch (Exception e) {
            System.out.println("2");
            i = 2;
            e.printStackTrace();
            return i;
        } finally {
            System.out.println("3");
            i = 3;
//            return i;
        }

//        System.out.println("4");
        i = 4;
        return i;
    }

}

interface t {

    public final static Integer i = 0;

    public default void t1() {
        System.out.println("212");
    }
}