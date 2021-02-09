package com.huhst.juc.order;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panbailiang
 * @Classname ThreadOrderAccess
 * @Date 2021/2/10 12:38 上午
 * 多线程实现顺序调用 ： 实现A->B->C
 * 三个线程启动要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * 循环10次
 * <p>
 * <p>
 * 1.高内聚低耦合的情况下，线程操作资源类
 * 2.判断/通知/干活
 * 3.多线程交互中，必须要防止线程间的虚假唤醒,即(使用while来进行判断而不是使用if)
 * 4.标志位
 * <p>
 * lock+condition实现精准通知
 */

class ShareResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     * 打印五次
     */
    public void five() {
        lock.lock();
        try {
            //判断
            while (number != 1) {
                condition1.await();
            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "打印了" + ++i + "\t" + number);
            }
            //通知
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印十次
     */
    public void ten() {
        lock.lock();
        try {
            //判断
            while (number != 2) {
                condition2.await();
            }
            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "打印了" + ++i + "\t" + number);
            }
            //通知
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印十五次
     */
    public void fifteen() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                condition3.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "打印了" + ++i + "\t" + number);
            }
            //通知
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * @author panbailiang
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.five();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.ten();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.fifteen();
            }
        }, "C").start();
    }
}
