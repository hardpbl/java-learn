package com.huhst.threadpool;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname 死锁
 * @Date 2021/4/26 8:30 上午
 *
 * jps      查看java进程号
 * jstack   c查看异常堆栈
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        MyLock myLock = new MyLock("A", "B");
        new Thread(new MyLock("A","B"),"AAAA").start();
        new Thread(new MyLock("B","A"),"BBBB").start();

    }
}

class MyLock extends Thread{
    private String A;
    private String B;

    public MyLock(String a, String b) {
        A = a;
        B = b;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (A){
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "\t 持有锁A，获取锁B" );
            TimeUnit.SECONDS.sleep(2);
            synchronized (B){
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "\t 持有锁B，获取锁A" );

            }
        }
    }
}
