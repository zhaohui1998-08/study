package com.zh.study.thread.threadsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Look锁
 */

class MyList {
    private Lock lock = new ReentrantLock();
    private String[] strArray = {"A", "B", "", "", ""};
    private int index = 2;

    public void add(String str) {
        //手动加锁
        lock.lock();

        try {
            strArray[index] = str;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            index++;
            System.out.println(Thread.currentThread().getName() + "添加了" + str);

        } finally {
            //释放锁,保证锁的释放
            lock.unlock();
        }
    }

    public String[] getStrArray() {
        return strArray;
    }
}


public class TestMyList {
    public static void main(String[] args) {
        MyList myList = new MyList();

        //匿名内部类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                myList.add("hello");
            }
        };
        //匿名内部类
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                myList.add("world");
            }
        };

        Thread t1 = new Thread(r1, "线程A");
        Thread t2 = new Thread(r2, "线程B");
        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String str : myList.getStrArray()) {
            System.out.println("str---" + str);
        }


    }
}
