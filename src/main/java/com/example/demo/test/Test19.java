package com.example.demo.test;

import java.util.*;

public class Test19 {

    private static Map<String, Integer> cards = new HashMap<>();

    private static Map<String, Integer> colors = new HashMap<>();

    static {

        cards.put("A", 1);
        cards.put("2", 2);
        cards.put("3", 3);
        cards.put("4", 4);
        cards.put("5", 5);
        cards.put("6", 6);
        cards.put("7", 7);
        cards.put("8", 8);
        cards.put("9", 9);
        cards.put("10", 10);
        cards.put("J", 11);
        cards.put("Q", 12);
        cards.put("K", 13);

        colors.put("H", 1);
        colors.put("S", 2);
        colors.put("C", 3);
        colors.put("D", 4);
    }

    public static void main(String[] args) {

        List<T1> t1List = new ArrayList<>();
        t1List.add(new T1("2", "H"));
        t1List.add(new T1("2", "S"));
        t1List.add(new T1("2", "D"));
        t1List.add(new T1("6", "H"));
        t1List.add(new T1("5", "H"));
        /*Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();
            t1List.add(new T1(line.split(" ")[0],line.split(" ")[1]));
        }*/

        t1List.sort(new Comparator<T1>() {
            @Override
            public int compare(T1 o1, T1 o2) {
                return cards.get(o1.getCard()) - cards.get(o2.getCard());
            }
        });

        if (tongHuaShun(t1List)) {
            System.out.println("1");
        } else if (siTiao(t1List)) {
            System.out.println("2");
        } else if (huLu(t1List)) {
            System.out.println("3");
        } else if (tongHua(t1List)) {
            System.out.println("4");
        } else if (shunZi(t1List)) {
            System.out.println("5");
        } else if (sanTiao(t1List)) {
            System.out.println("6");
        } else {
            System.out.println("7");
        }


    }

    /**
     * 判断是不是同花顺
     *
     * @param t1List
     * @return
     */
    public static Boolean tongHuaShun(List<T1> t1List) {
        int count = 1;
        for (int i = 1; i < t1List.size(); i++) {
            T1 t1 = t1List.get(i);
            for (int j = 1; j < t1List.size(); j++) {
                T1 t2 = t1List.get(j);
                if (cards.get(t2.getCard()) - cards.get(t1.getCard()) == 1 && t1.getColor().equals(t1.getColor())) {
                    count++;
                    if (count == t1List.size()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 判断是不是四条
     *
     * @param t1List
     * @return
     */
    public static Boolean siTiao(List<T1> t1List) {
        int count = 0;
        for (int i = 0; i < t1List.size(); i++) {
            count = 0;
            T1 t1 = t1List.get(i);
            for (int j = 0; j < t1List.size(); j++) {
                T1 t2 = t1List.get(j);
                if (t1.getCard().equals(t2.getCard())) {
                    count++;

                    if (count == t1List.size() - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 判断是不是葫芦
     *
     * @param t1List
     * @return
     */
    public static Boolean huLu(List<T1> t1List) {
        int count = 0;
        String card = "";
        for (int i = 0; i < t1List.size(); i++) {
            count = 0;
            T1 t1 = t1List.get(i);
            for (int j = 0; j < t1List.size(); j++) {
                T1 t2 = t1List.get(j);
                if (t1.getCard().equals(t2.getCard())) {
                    count++;
                    card = t1.getCard();
                }
            }
        }

        int count2 = 0;
        for (int i = 0; i < t1List.size(); i++) {
            count2 = 0;
            T1 t1 = t1List.get(i);
            if (!card.equals(t1.getCard())) {
                for (int j = 0; j < t1List.size(); j++) {
                    T1 t2 = t1List.get(j);
                    if (t1.getCard().equals(t2.getCard())) {
                        count2++;
                        if (count2 + count == t1List.size()) {
                            return true;
                        }
                    }
                }
            }
        }

        return (count == 3 && count2 == 2) || (count == 2 && count2 == 3);
    }

    /**
     * 判断是不是同花
     *
     * @param t1List
     * @return
     */
    public static Boolean tongHua(List<T1> t1List) {
        T1 t1 = t1List.get(0);
        int count = 1;
        for (int i = 1; i < t1List.size(); i++) {
            T1 t2 = t1List.get(i);
            if (t1.getColor().equals(t2.getColor())) {
                count++;
                if (count == t1List.size()) {
                    return true;
                }
            }

            t1 = t2;
        }

        return false;
    }

    /**
     * 判断是不是顺子
     *
     * @param t1List
     * @return
     */
    public static Boolean shunZi(List<T1> t1List) {
        T1 t1 = t1List.get(0);
        int count = 1;
        for (int i = 1; i < t1List.size(); i++) {
            T1 t2 = t1List.get(i);
            if (cards.get(t2.getCard()) - cards.get(t1.getCard()) == 1) {
                count++;
                if ( count == t1List.size()){
                    return true;
                }
            }

            t1 = t2;
        }

        return false;
    }

    /**
     * 判断是不是三条
     *
     * @param t1List
     * @return
     */
    public static Boolean sanTiao(List<T1> t1List) {
        int count = 0;
        for (int i = 0; i < t1List.size(); i++) {
            T1 t1 = t1List.get(i);
            for (int j = 0; j < t1List.size(); j++) {
                T1 t2 = t1List.get(j);
                if (t1.getCard().equals(t2.getCard())) {
                    count++;
                    if (count == t1List.size() - 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}

class T1 {
    private String card;

    private String color;

    public T1(String card, String color) {
        this.card = card;
        this.color = color;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}