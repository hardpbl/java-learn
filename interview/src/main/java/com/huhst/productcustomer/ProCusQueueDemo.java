package com.huhst.productcustomer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author panbailiang
 * @Classname 无锁版生产者消费者
 * @Date 2021/4/25 2:02 下午
 */
public class ProCusQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new LinkedBlockingQueue<>(10));
        new Thread(()->{
            try {
                myResource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产线程").start();

        new Thread(()->{
            try {
                myResource.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费线程").start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("主线程说大家都要停止了");
        myResource.stop();
    }
}

class MyResource{
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println("blockingQueue.getClass().getName() = " + blockingQueue.getClass().getName());
    }

    public void myProd() throws InterruptedException {
        String data = null;
        boolean returnValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet() + "";
            returnValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnValue){
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "\t 插入队列成功" + data );
            }else {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "\t 插入队列失败" + data );
            }
            TimeUnit.SECONDS.sleep(1);
        }

    }

    public void consumer() throws InterruptedException {
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || "".equals(result)){
                FLAG = false;
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "\t超过两秒未获取到数据，消费推出");
                return;
            }
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "\t消费队列成功" + result);
        }

    }

    public void stop(){
        FLAG = false;
    }
}