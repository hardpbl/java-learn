package com.huhst.volatiles;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author panbailiang
 * @Classname AutomicDemo
 * @Date 2021/3/27 5:45 下午
 *
 * JMM是要求保证原子性的，但是我们的volatile是没有实现原子性
 *
 *
 * 原子性
 * 完整性，某个线程做某个具体业务的时候不可加塞或者分割，需要整体完成或者整体失败
 *
 * 简单的解决方法：
 *                      synchronized (AutomicDemo.class) {
 *                         myData2.addPlusPlus();
 *                     }
 *
 * 为什么number++不能保证原子性：
 *      number++ =>字节码中变成了四条指令，可能会出现线程挂起的问题，会出现写覆盖的问题
 *
 * 解决办法：
 *  方法一：synchronized
 *  方法二：使用atomic来实现
 *      底层原理
 *
 *
 */
public class AutomicDemo {

    public static void main(String[] args) {
        MyData2 myData2 = new MyData2();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                        myData2.addPlusPlus();
                        myData2.addPlusPlusByLock();
                }
            },String.valueOf(i)).start();
        }
        //需要等待上面20个线程全部计算完，在用main线程取得最终结果
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "最终的值：" + myData2.number);
        System.out.println(Thread.currentThread().getName() + "最终的值Lock：" + myData2.atomicInteger);

    }
}

class MyData2 {
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addPlusPlus() {
        number ++;
    }

    public void addPlusPlusByLock() {
        atomicInteger.getAndIncrement();
    }
}
