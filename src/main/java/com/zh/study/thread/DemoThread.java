package com.zh.study.thread;


//继承Thread重写run 来创建线程
class TestThrad extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("守护线程打印了----" + i);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class DemoThread {
    public static void main(String[] args) {
        //启动一个守护线程
        TestThrad testThrad = new TestThrad();
        //就说明这个线程是守护线程 主线程挂了守护线程也就挂了
        testThrad.setDaemon(true);
        testThrad.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程打印了" + i);
        }

    }
}
