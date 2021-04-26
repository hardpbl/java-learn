package com.huhst.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author panbailiang
 * @Classname CallAbleDemo
 * @Date 2021/4/26 8:00 上午
 */
public class CallAbleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //找中间人
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"AA").start();
        //BB不会执行
        new Thread(futureTask,"BB").start();

        System.out.println("futureTask.get() = " + futureTask.get());
    }
}

class MyThread implements Callable{

    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}
