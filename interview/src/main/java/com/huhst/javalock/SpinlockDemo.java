package com.huhst.javalock;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author panbailiang
 * @Classname SpinlockDemo
 * @Date 2021/4/5 6:49 下午
 *
 * 自旋锁
 *      是指尝试获取锁的线程不会立马阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程上下文切换
 *      带来的消耗，缺点是耗费cpu资源
 *      没有类似wait的等待
 *
 *      自旋，本质还是循环去比较，这里我们可以使用原子引用来实现比较并交换，实现线程安全
 *
 */
public class SpinlockDemo {
    AtomicReference atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t进入了myLock方法");
        while (atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t进入了myUnLock方法");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinlockDemo spinlockDemo = new SpinlockDemo();
        new Thread(()->{
            spinlockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinlockDemo.myUnLock();
        },"t1").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            spinlockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinlockDemo.myUnLock();
        },"t2").start();
    }
}
