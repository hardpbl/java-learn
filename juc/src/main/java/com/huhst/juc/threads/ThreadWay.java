package com.huhst.juc.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author panbailiang
 * @Classname ThreadWay
 * @Date 2021/2/10 10:31 下午
 *
 * 实现多线程的方式
 *
 *  1。继承Thread类
 *  2。实现Runnable接口
 *  3。实现Callable接口
 *      Callable接口和Runnable接口的区别：
 *          1。是否有异常
 *          2。是否有返回值
 *          3。落地方法不一样，一个叫call一个叫run
 *  Callable接口的细节
 *  FutureTask 切换一个异步线程出来
 *  get方法一般放在最后一行，未算完就去get会导致线程阻塞
 *
 *  //多态 A C  找一个桥梁B，实现 A->B->C
 *  1:new Thread(stringFutureTask,"A").start();
 *  2:new Thread(stringFutureTask,"B").start();
 *  只会调用一次
 *
 */
public class ThreadWay {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        FutureTask<String> stringFutureTask = new FutureTask<>(myThread);
        //多态 A C  找一个桥梁B，实现 A->B->C
        new Thread(stringFutureTask,"A").start();
        new Thread(stringFutureTask,"B").start();
        System.out.println(stringFutureTask.get());
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("hello Callable.....");
        return "1024";
    }
}

class MyThread1 implements Runnable {

    @Override
    public void run() {

    }
}