package com.example.demo.test;

import java.util.*;

public class Test22 {

    private static int minPath(int n, int[][] edges, int start, int end) {
        Stack<Integer[]> stack = new Stack();
        Path pathT = new Path();
        List<Path> pathList = new ArrayList<>();
        stack.addAll(getPort(edges, start));
        while (!stack.isEmpty()) {
            Integer[] pop = stack.pop();
            pathT.pathSum = pathT.pathSum + pop[1];
            pathT.path.add(pop[0]);
            pathT.pathLength.add(pop[1]);
            if (pop[0].equals(end)) {
                pathList.add(pathT);
                pathT = new Path();
            } else if (pop[0].equals(start)) {
                pathT = new Path();
            } else {
                List<Integer[]> port = getPort(edges, pop[0]);
                stack.addAll(port);
            }
        }

        Path pathMin = new Path();
        pathMin.pathSum = Integer.MAX_VALUE;
        for (Path path : pathList) {
            if (path.pathSum <= pathMin.pathSum) {
                pathMin = path;
            }
        }

        if (pathMin.path.size() < 2) {
            return pathMin.pathLength.get(0);
        } else {
            int result = pathMin.pathLength.get(0);
            for (Integer i = 1; i < pathMin.pathLength.size(); i++) {
                result = result | pathMin.pathLength.get(i);
            }

            return result;
        }

    }

    /**
     * 获取下一个节点
     */
    private static List<Integer[]> getPort(int[][] edges, int start) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == start) {
                Integer[] array = {edges[i][1], edges[i][2]};
                list.add(array);
            }
        }

        return list;
    }


    public static void main(String[] args) {
        int[][] edges = {{1, 2, 1}, {2, 3, 3}, {1, 3, 100}};
        System.out.println(minPath(edges.length, edges, 1, 3));
    }
}

class Path {
    /**
     * 路径
     */
    public List<Integer> path = new ArrayList<>();

    /**
     * 每个路径长度
     */
    public List<Integer> pathLength = new ArrayList<>();

    /**
     * 路径总长度
     */
    public Integer pathSum = 0;
}