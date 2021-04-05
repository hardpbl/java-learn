package com.huhst.javalock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panbailiang
 * @Classname JavaLockDemo
 * @Date 2021/4/5 4:45 下午
 *
 * java里面的锁
 * 公平和非公平锁
 *      his is equivalent to using {@code ReentrantLock(false)}
 *      new ReentrantLock();
 *
 * 是什么：
 *      公平：先来后到，按顺序执行
 *      非公平：允许加塞，尝试占有锁，失败再采取类似公平锁的方式，获取锁的顺序并不是按照申请的顺序执行，在高并发的情况下会造成优先级或饥饿现象
 *      Lock（无参数）/Synchronize都是非公平锁
 *
 *      可重入锁(又名递归锁)
 *          线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *          理论+敲代码=小总结
 *          当某一个线程获得了method1的锁的时候自然而然的获取到的了method2的锁对象
 *
 *          作用：防止死锁
 *
 *          public synchronized void method1(){
 *              method2();
 *          }
 *          public synchronized void method2(){
 *
 *          }
 *
 *
 *
 *
 *
 *
 */
public class JavaLockDemo {
    public  static void main(String[] args) {
        Lock lock = new ReentrantLock();
    }
}
