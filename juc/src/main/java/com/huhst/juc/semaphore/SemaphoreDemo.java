package com.huhst.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname SemaporeDemo
 * @Date 2021/2/12 11:28 下午
 * <p>
 * 信号量
 * <p>
 * 信号量主要是
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //资源是1个的时候可以用来当成sync来使用
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t" + "抢占到了车位");
                    //休眠一会
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t" + "离开了了车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
