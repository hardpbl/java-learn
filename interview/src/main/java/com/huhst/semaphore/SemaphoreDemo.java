package com.huhst.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname SemaphoreDemo
 * @Date 2021/4/12 8:31 上午
 * <p>
 * 信号量
 * 设置为1，可以替换为synchronize
 * 两个作用：
 * 一个
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t" + finalI + "抢到了车位");
                    //停三秒
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + finalI + "释放了车位");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
