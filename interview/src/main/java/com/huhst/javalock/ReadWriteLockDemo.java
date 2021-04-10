package com.huhst.javalock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author panbailiang
 * @Classname ReadWriteLockDemo
 * @Date 2021/4/10 10:58 上午
 * <p>
 * volatile 保证可见性
 * 写：原子性，不可打断，整个过程必须是完整的，中间不许被分割，被打断
 *
 * 写完再读
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.put(String.valueOf(finalI),String.valueOf(finalI));
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.get(String.valueOf(finalI));
            },String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private volatile Map<String, String> map = new ConcurrentHashMap<>();

    //假如读写锁保证读写的原子性
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key, String value) {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
        try {
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成:" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key) {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在读取：" + key);
        try {
            TimeUnit.MILLISECONDS.sleep(300);
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}
