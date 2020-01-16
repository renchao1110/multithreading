package com.cn.glodon.thread02;

/**
 * @author ：renc
 * @date ：Created in 2020/1/16 17:21
 * @description：测试volatile关键字的原子性,volatile多线程不具备多线程原子性
 *
 */
public class VolatileTest extends Thread{

    private static volatile int num = 0;



    public /*synchronized*/ /*static*/ void count(){
        for (int i=0 ;i<10;i++){
            num++;
        }
        System.out.println(num);
    }

    @Override
    public void run() {
        count();
    }

    public static void main(String[] args) {
        VolatileTest[] volatileTest = new VolatileTest[10];

        for (int i = 0; i < 10; i++) {
            volatileTest[i] = new VolatileTest();
        }

        for (int i = 0; i < 10; i++) {
            volatileTest[i].start();
        }
    }
}
