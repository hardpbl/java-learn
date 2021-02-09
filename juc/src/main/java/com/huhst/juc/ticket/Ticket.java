package com.huhst.juc.ticket;

/**
 * @author panbailiang
 * @Classname Ticket
 * @Date 2021/2/8 6:02 下午
 * <p>
 * 线程-操作-资源类
 * synchronized 来实现锁🔒
 */


public class Ticket {
    /**
     * 资源类
     */
    private int number = 30;

    public synchronized void saleTicket() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "\t卖出第" + number-- +"还剩"+number);
        }
    }
}

class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"A");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"B");
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"C");
        t3.start();
    }
}
