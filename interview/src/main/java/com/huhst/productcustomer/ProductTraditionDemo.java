package com.huhst.productcustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panbailiang
 * @Classname ProductTraditionDemo
 * @Date 2021/4/15 8:15 上午
 *
 * 题目：
 *      一个初始值为0的变量，两个线程交替操作，一个加一一个减一，操作5轮
 *      1。线程    操作   资源类
 *      2。判断    干活   通知
 *      3。防止虚假唤醒
 */
public class ProductTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 1; i <= 5 ; i++) {
            new Thread(()->{
                shareData.create();
            },"AA").start();

            new Thread(()->{
                shareData.delete();
            },"BB").start();

            new Thread(()->{
                shareData.create();
            },"CC").start();

            new Thread(()->{
                shareData.delete();
            },"DD").start();
        }


    }
}

class ShareData{
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void create(){
        lock.lock();
        try{
            while (number!=0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t 生产了 " + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void delete(){
        lock.lock();
        try{
            while (number==0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t 消费了 = " + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
