package com.cn.glodon.thread01;

/**
 * @author ：renc
 * @date ：Created in 2020/1/16 14:49
 * @description：类锁
 */
public class MultiThread{
    private static int num = 0;
    public static synchronized void printNum(String param){
        if ("a".equals(param)){
            num = 100;
            System.out.println("a---参数=="+param+"====num=="+num);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            num = 200;
            System.out.println("b---参数=="+param+"====num=="+num);
        }
        System.out.println("--------参数=="+param+"====num=="+num);
    }


    public static void main(String[] args) {
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(() -> MultiThread.printNum("a"));
        Thread t2 = new Thread(() -> MultiThread.printNum("b"));

        t1.start();
        t2.start();

    }
}
