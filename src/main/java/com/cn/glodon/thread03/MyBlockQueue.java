package com.cn.glodon.thread03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：renc
 * @date ：Created in 2020/1/17 9:43
 * @description：自己模拟实现一个阻塞队列
 */
public class MyBlockQueue {

    private volatile int temp = 0;
    private LinkedList<String> list = new LinkedList<>();
    private final int MAX = 5;

    public void produce(String value){
        synchronized (list){
            while (temp==MAX){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(value);
            temp = list.size();
            System.out.println("队列添加了一个元素"+"-----"+value+"---现在队列大小为"+temp);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.notify();
        }
    }


    public void consume(){
        synchronized (list){
            while (temp==0){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String value = list.poll();
            temp--;
            System.out.println("队列取出了一个元素"+"-----"+value+"---现在队列大小为"+temp);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.notify();
        }
    }


    public static void main(String[] args) {
        MyBlockQueue queue = new MyBlockQueue();
        String[] arr = new String[]{"a","b","c","d","e","f","g","h","z","x"};
        queue.produce("a");
        queue.produce("b");
        queue.produce("c");
        queue.produce("d");
        queue.produce("e");


        new Thread(() -> queue.produce("f")).start();



        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> queue.consume()).start();


    }
}
