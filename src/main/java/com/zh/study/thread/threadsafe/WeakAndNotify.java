package com.zh.study.thread.threadsafe;

/**
 * 等待唤醒机制
 */
public class WeakAndNotify {
    public static void main(String[] args) {
        //这是个协调者 中间人
        Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("顾客1告诉老板要的早餐");
                //进入等待
                synchronized (lock) {
                    try {
                        lock.wait();//wait等待的时候会释放锁，进入等待池之中等待被唤醒，被唤醒后会从重新去竞争锁资源，拿到锁之后会继续执行后面的代码 没拿到有可能从新进入等待状态
                                    //sleep在等待的时间不会释放锁
                        //lock.wait(4000);这种情况等待指定的时间 不被唤醒也会自己醒来
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("顾客1拿到老板给的早餐，开始吃。");

            }
        }, "顾客1线程").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("顾客2告诉老板要的早餐");
                //进入等待
                synchronized (lock) {
                    try {
                        lock.wait();//等待的时候会释放锁，进入等待池之中等待被唤醒，被唤醒后会从重新去竞争锁资源，拿到锁之后会继续执行后面的代码
                        //lock.wait(4000);这种情况等待指定的时间 不被唤醒也会自己醒来
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("顾客2拿到老板给的早餐，开始吃。");

            }
        }, "顾客2线程").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                //等待2秒
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("2.老板给顾客产品");
                //通知顾客
                synchronized (lock) {
                    //通知顾客，会去等待池里面告诉线程该醒了
                    lock.notifyAll();
                }

            }
        }, "老板线程").start();


    }
}
