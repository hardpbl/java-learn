package com.huhst.juc.notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panbailiang
 * @Classname ThreadWaitNotifyDemo
 * @Date 2021/2/9 11:29 下午
 * <p>
 * 两个线程，一个线程对变量+1。一个线程对变量-1，交替来10轮
 * <p>
 * 线程操作资源类
 * 判断/干活/通知
 * <p>
 * 多线程交互中，必须要防止线程的虚假唤醒，也即(判断只用while，不用if)
 * <p>
 * 使用Lock相关API来实现等待/通知
 * wait->await
 * notify->signal
 */

class LockAirConditioner {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void addTemperature() throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                //C A 两个线程卡在这等待，当被唤醒的时候拿到CPU执行权同时对下面的++进行操作
                this.condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "生产了：" + "\t" + number);
            //通知
//            this.notifyAll();
            this.condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void subTemperature() throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (number == 0) {
//                this.wait();
                this.condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "消费了：" + "\t" + number);
            //通知
//            this.notifyAll();
            this.condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @author panbailiang
 * 两个线程结果：
 * A生产了：	1
 * B消费了：	0
 * A生产了：	1
 * B消费了：	0
 * 四个线程执行的结果：
 * A生产了：	1
 * C生产了：	2
 * A生产了：	3
 * D消费了：	2
 */
public class LockThreadWaitNotifyDemo {
    public static void main(String[] args) {
        LockAirConditioner airConditioner = new LockAirConditioner();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    airConditioner.addTemperature();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    airConditioner.subTemperature();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        //四个线程
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    airConditioner.addTemperature();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    airConditioner.subTemperature();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "D").start();
    }
}
