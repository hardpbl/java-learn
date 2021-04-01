package com.huhst.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname VolatileDemo
 * @Date 2021/3/27 5:00 下午
 *
 * 三大特性
 *      保证可见性
 *      不保证原子性
 *      禁止指令重排
 *
 *      JMM(java内存模型)
 *
 *      cpu的速度与内存的速度不一致
 *
 *      多线程情况下每个线程的工作内存都有一个本地变量拷贝，我们对变量的拷贝改变后要能立刻能通知到其他线程
 *
 *      理论+代码 =》小总结
 *
 *      轻量级的实现，不保证原子性，低配版的synconize
 */
public class VolatileDemo {
    /**
     * 验证volatile的可见效
     * 1.1 假如 int number =0 ;number变量之前根本没有添加volatile关键字，没有可见性
     * 1.2 添加了volatile后，保证了可见效
     * 增强主副内存之间的可见效
     *
     *
     */
    public static void main(String[] args) {

        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t" +"come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add60();
            System.out.println(Thread.currentThread().getName()+"\t" +"update number value:" + myData.number);

        },"AAA").start();

        while (myData.number == 0){}
        System.out.println(Thread.currentThread().getName() + "\t"+"method over");


    }
}

class MyData {
    volatile int number = 0;
    public void add60() {
        this.number = 60;
    }
}
