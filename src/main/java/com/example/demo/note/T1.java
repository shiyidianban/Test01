package com.example.demo.note;

import com.example.demo.test01.offer.T03;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author FLY
 * @date 2020-06-27 12:56
 */
public class T1 {

    void addTT(Integer n) {
        n = 5;
    }

    void addTT(P p) {
        p.i = 5;
    }

    public static void main(String[] args) {
        T03  t = new T03();

        Semaphore semaphore  = new Semaphore(6);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Integer n = 2;
        T1 t1 = new T1();
        t1.addTT(n);
        System.out.println(n);

//        WeakReference t = new WeakReference();

        P p = new P();
        p.i = 2;
        t1.addTT(p);
        System.out.println(p.i);
    }
}

class P{
    Integer i;
}
