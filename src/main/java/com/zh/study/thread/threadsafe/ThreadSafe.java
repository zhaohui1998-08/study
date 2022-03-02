package com.zh.study.thread.threadsafe;

class Ticket implements Runnable {
    private  int ticket = 100;

    @Override
    public void run() {
        while (true) {//只要有票就一直卖 一直处于营业状态
            //模拟一下出票时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket >0){
                System.out.println(Thread.currentThread().getName() + "卖了:" + ticket--);
            }
        }
    }
}


public class ThreadSafe {
    public static void main(String[] args) {
        //启动三个窗口
        Ticket ticket = new Ticket();
        new Thread(ticket,"窗口1").start();
        new Thread(ticket,"窗口2").start();
        new Thread(ticket,"窗口3").start();


    }
}
