package com.cn.glodon.thread02;

/**
 * @author ：renc
 * @date ：Created in 2020/1/16 16:38
 * @description：volatile关键字可以使变量在多线程之间可见
 */
public class RunThread extends Thread {
    private volatile boolean condition = true;

    @Override
    public void run() {
        System.out.println("进入run方法，线程启动");
        while (true == condition){
            boolean a = condition;
        }
        System.out.println("线程执行完毕");
    }


    public static void main(String[] args) {
        RunThread runThread = new RunThread();
        Thread thread = new Thread(runThread,"t1");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runThread.condition = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("runThread.condition==="+runThread.condition);
    }
}
