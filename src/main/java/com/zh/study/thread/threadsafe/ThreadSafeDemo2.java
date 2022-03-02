package com.zh.study.thread.threadsafe;

class Ticket2 implements Runnable {
    private static int ticket = 100;
    Object look = new Object();

    @Override
    public void run() {
        while (true) {//只要有票就一直卖 一直处于营业状态

            /*
            用同步代码块解决线程安全问题
            语法synchronized (临界资源对象){ //对临界资源对象加锁
            代码（原子操作）
            }
             */

            //每次只会允许一个线程进来执行里面的代码 其他线程进入阻塞状态
            //synchronized (look) {  也可以用this 是个对象就行
            //synchronized (this) {
            synchronized (ThreadSafeDemo2.class) {  //.class文件加载到内存的时候，只会创建一个class类的对象
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
    }
}


public class ThreadSafeDemo2 {
    public static void main(String[] args) {
        //启动三个窗口
//        Ticket ticket = new Ticket();
//        new Thread(ticket, "窗口1").start();
//        new Thread(ticket, "窗口2").start();
//        new Thread(ticket, "窗口3").start();
        //这样会出现synchronized锁不住的现象 可以改变为ThreadSafeDemo2.class来进行锁 还有就是这里new多次时 成原变量加个Static 要不然会有多份数据
        new Thread(new Ticket2(),"窗口一").start();
        new Thread(new Ticket2(),"窗口二").start();
        new Thread(new Ticket2(),"窗口三").start();


    }
}
