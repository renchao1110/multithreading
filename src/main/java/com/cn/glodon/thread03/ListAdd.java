package com.cn.glodon.thread03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：renc
 * @date ：Created in 2020/1/16 17:55
 * @description：多线程之间的通信
 */
public class ListAdd {
    private /*volatile*/ static List<String> list = new ArrayList<>();

    public void add(){
        list.add("Jack");
    }

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        ListAdd listAdd = new ListAdd();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                listAdd.add();
                System.out.println("当前线程—"+Thread.currentThread().getName()+"添加了一个元素");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");



        Thread t2 = new Thread(() -> {
            while (true){
                if (listAdd.size()==5){
                    System.out.println("当前线程--"+Thread.currentThread().getName()+"收到通知，结束线程");
                    throw new RuntimeException();
                }
            }
        },"t2");

        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
