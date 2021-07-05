package com.huhst.juc.night.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author bailiang.pan@hand-china.com
 * @Classname NightLock
 * @Date 2021/2/10 8:35 下午
 * <p>
 * 线程8锁
 * 打印顺序--不一定，由线程调度决定
 * 1。标准访问先打印发送邮件还是先打印发送短信
 * //同一时刻多个synchronized锁定的方法，锁的对象是this，只能有一个线程进入资源类，操作唯一一个synchronized方法，
 * 2。邮件暂停4s，请问先打印邮件还是短信
 * //看谁先抢到cpu执行权
 * 3。新增一个hello()方法，请问先打印hello还是邮件
 * 先打印hello()
 * 4。两部手机先打印邮件还是短信
 * 两个不一样的对象，锁不一样，看cpu执行权了
 * 5。两个静态方法，同一部手机，请问先打印短信还是邮件
 * <p>
 * 6。两个静态方法，两部手机，请问先打印短信还是邮件
 * 5。6的锁的对象不是实例，而是class文件
 * 7。一个普通同步方法，一个静态同步方法，一部手机，先打印短信还是邮件
 * 两个不一样的锁，普通同步方法锁的对象是this，静态同步方法锁的对象是class
 * 8。一个普通同步方法，一个静态同步方法，两部手机，先打印短信还是邮件
 * 锁的对象不一样，普通对应的是this，静态的是class文件
 * <p>
 * Synchronized实现同步的基础，java中每一个对象都可以作为锁的对象
 * 具体表现为3种形式
 * 1。对于普通同步方法，锁的对象是this
 * 2。对于静态同步方法，锁是当前类的class文件
 * 3。对于同步代码块，锁的对象是括号里面配置的对象
 */
public class NightLock {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
//                TimeUnit.SECONDS.sleep(10);
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                phone2.sendMes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}

class Phone {
    public static synchronized void sendEmail() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("...email...");
    }

    public static synchronized void sendMes() throws Exception {
        System.out.println("...mes...");
    }

}