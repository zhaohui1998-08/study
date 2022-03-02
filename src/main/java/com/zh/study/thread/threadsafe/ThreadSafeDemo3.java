package com.zh.study.thread.threadsafe;

class Ticket3 implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {//只要有票就一直卖 一直处于营业状态
            //调用同步方法
            sellTicket();
        }
    }

    /**
     * synchronized修饰方法。保证线程A执行此方法的时候其余县城只能在方法外等着
     * synchronized 返回值类型 方法名称 （参数列表）
     * 有这个synchronized时对当前对象（this）加锁
     */
    public synchronized static void sellTicket(){ //static静态的相当于Ticket3.class new几个Ticket3都没有关系了
        if (ticket > 0) {
            //模拟一下出票时间
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖了:" + ticket--);
        }
    }
}


public class ThreadSafeDemo3 {
    public static void main(String[] args) {
        //启动三个窗口
        Ticket3 ticket3 = new Ticket3();
        new Thread(new Ticket3(),"窗口一").start();
        new Thread(new Ticket3(),"窗口二").start();
        new Thread(new Ticket3(),"窗口三").start();


    }
}
