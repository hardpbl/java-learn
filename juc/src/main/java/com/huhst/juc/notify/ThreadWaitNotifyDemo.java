package com.huhst.juc.notify;

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
 * wait是指在一个已经进入了同步锁的线程内，让自己暂时让出同步锁，以便其他正在等待此锁的线程可以得到同步锁并运行，
 * 只有其他线程调用了notify方法（notify并不释放锁，只是告诉调用过wait方法的线程可以去参与获得锁的竞争了，
 * 但不是马上得到锁，因为锁还在别人手里，别人还没释放），调用wait方法的一个或多个线程就会解除wait状态，
 * 重新参与竞争对象锁，程序如果可以再次得到锁，就可以继续向下运行。
 */

class AirConditioner {
    private int number = 0;

    public synchronized void addTemperature() throws InterruptedException {
        //判断
        while (number != 0) {
            //C A 两个线程卡在这等待，当被唤醒的时候拿到CPU执行权同时对下面的++进行操作
            //使用while来进行判断，解决if条件顺序执行的问题
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName() + "生产了：" + "\t" + number);
        //通知
        this.notifyAll();
    }

    public synchronized void subTemperature() throws InterruptedException {
        //判断
        while (number == 0) {
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName() + "消费了：" + "\t" + number);
        //通知
        this.notifyAll();
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
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
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
