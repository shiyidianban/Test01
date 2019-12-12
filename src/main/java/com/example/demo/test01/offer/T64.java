package com.example.demo.test01.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T64 {

    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, new ComParatorMax<>());

    public void Insert(Integer num) {
        count++;
        // 当数据的个数为奇数时，进入大根堆
        if ((count & 1) == 1) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (count == 0)
            return null;
        // 当数据个数是奇数时，中位数就是大根堆的顶点
        if ((count & 1) == 1) {
            return Double.valueOf(maxHeap.peek());
        } else {
            return Double.valueOf((minHeap.peek() + maxHeap.peek())) / 2;
        }
    }

    class ComParatorMax<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            // TODO Auto-generated method stub
            return 0;
        }
    }
}


