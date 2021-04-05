package com.huhst.javalock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panbailiang
 * @Classname ReenterLockDemo
 * @Date 2021/4/5 5:02 下午
 *
 * 可重入锁
 *
 *      synchronize
 *          public synchronized void sendSms(){
 *               System.out.println(Thread.currentThread().getName() + "\t" + "invoke sendSms");
 *               sendMail();
 *          }
 *          public synchronized void sendMail(){
 *              System.out.println(Thread.currentThread().getName() + "\t" + "invoke sendMail");
 *          }
 *      lock版本
 *
 *      定义多个lock.lock()，一定要定义多个lock.unlock()，否则会出现死锁现象
 *
 */
public class ReenterLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSms();
        },"t1").start();

        new Thread(()->{
            phone.sendSms();
        },"t2").start();


        TimeUnit.SECONDS.sleep(3);
        Phone phone1 = new Phone();
        Thread t3 = new Thread(phone1);
        Thread t4 = new Thread(phone1);
        t3.start();
        t4.start();

    }
}


class Phone implements Runnable{
    public synchronized void sendSms(){
        System.out.println(Thread.currentThread().getName() + "\t" + "invoke sendSms");
        sendMail();
    }
    public synchronized void sendMail(){
        System.out.println(Thread.currentThread().getName() + "\t" + "invoke sendMail");
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "invoke get");
            set();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t" + "invoke set");
        }finally {
            lock.unlock();
        }
    }
}