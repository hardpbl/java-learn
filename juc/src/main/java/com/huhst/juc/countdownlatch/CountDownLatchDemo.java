package com.huhst.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author panbailiang
 * @Classname CountDownLatchDemo
 * @Date 2021/2/12 11:09 下午
 *
 * 倒计数走人实现
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t" + "离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "班长关门走人");
    }
}
