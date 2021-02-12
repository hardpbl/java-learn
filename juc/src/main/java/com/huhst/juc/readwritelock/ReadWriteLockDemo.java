package com.huhst.juc.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author panbailiang
 * @Classname ReadWriteLockDemo
 * @Date 2021/2/12 11:38 下午
 *
 * 读写锁
 *
 * 读应该是共享的，写应该是独立的
 *
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    myCache.put(finalI +"", finalI +"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    myCache.get(finalI +"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}

class MyCache{
    private volatile Map<String, Object> map =new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key, Object value) throws InterruptedException {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "写入数据");
            TimeUnit.SECONDS.sleep(3);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t" + "写入数据完成" + value);
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }
    public void get(String key) throws InterruptedException {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "获取数据");
            TimeUnit.SECONDS.sleep(3);
            Object obj = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t" + "读取数据完成 ：" + obj);
        }finally {
            readWriteLock.readLock().unlock();
        }

    }
}
