package com.cn.glodon.thread01;

/**
 * @author ：renc
 * @date ：Created in 2020/1/16 15:39
 * @description：${description}
 */
public class MyThread extends Thread{

    private int count = 5;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"----count==="+count);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        new Thread(myThread,"t1").start();
        new Thread(myThread,"t2").start();
        new Thread(myThread,"t3").start();
        new Thread(myThread,"t4").start();
        new Thread(myThread,"t5").start();
    }
}
