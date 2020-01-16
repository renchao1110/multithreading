package com.cn.glodon.thread01;

/**
 * @author ：renc
 * @date ：Created in 2020/1/16 16:04
 * @description：${description}
 */
public class MyObject {

    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2(){
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        new Thread(() -> myObject.method1(),"t1").start();
        new Thread(() -> myObject.method2(),"t2").start();
    }
}
