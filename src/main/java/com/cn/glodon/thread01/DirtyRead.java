package com.cn.glodon.thread01;

/**
 * @author ：renc
 * @date ：Created in 2020/1/16 16:14
 * @description：业务模仿脏读
 */
public class DirtyRead {
    private String name = "jack";
    private String pwd = "123456";

    public synchronized void setValue(String name,String pwd){
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pwd = pwd;
        System.out.println("设置完成==="+"name=="+name+"-----pad==="+pwd);
    }

    public void getValue(){
        System.out.println("获取----"+"name=="+name+"-----pad==="+pwd);
    }


    public static void main(String[] args) {
        DirtyRead dirtyRead = new DirtyRead();
        new Thread(() -> dirtyRead.setValue("tom","654321"),"t1").start();
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        new Thread(() -> dirtyRead.getValue(),"t2").start();
    }
}
