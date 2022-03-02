package com.zh.study.thread.threadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


class Myrunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("我要一个教练");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("教练来了"+ Thread.currentThread().getName());
        System.out.println("教完后教练回了泳池。");
    }
}


public class ThreadPoolDemo {
    public static void main(String[] args) {

        //创建线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 创建runnable接口子类对象
        Myrunnable myrunnable = new Myrunnable();

        pool.submit(myrunnable);
        pool.submit(myrunnable);
        pool.submit(myrunnable);



    }
}
