package com.huhst.juc.ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panbailiang
 * @Classname Ticket
 * @Date 2021/2/8 6:02 下午
 * <p>
 * 线程-操作-资源类
 * <p>
 * 可重入锁
 * 使用lock来实现，lock的粒度更细
 * t1.start()只是线程就绪了，需要操作系统底层调度通知。
 * <p>
 * 就绪->运行->阻塞
 * <p>
 * sleep/wait 阻塞
 * <p>
 * wait：放弃cpu的执行权
 * sleep：醒来继续持有cpu的执行权
 * <p>
 * 不用实现Runnable接口，高内聚低耦合
 */


public class TicketDemoLambda {

    /**
     * 资源类
     */
    private int number = 30;
    private Lock lock = new ReentrantLock();

    public synchronized void saleTicket() {
        try {
            lock.lock();
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第" + number-- + "还剩" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

class SaleTicketDemoLambda {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket();
            }
        }, "C").start();
    }
}
