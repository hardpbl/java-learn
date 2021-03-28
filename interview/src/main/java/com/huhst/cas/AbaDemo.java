package com.huhst.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author panbailiang
 * @Classname AbaDemo
 * @Date 2021/3/28 11:54 下午
 */
public class AbaDemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(100, 1);

    public static void main(String[] args) {
        System.out.println("==================ABA问题================");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                //因为线程的执行并不是按我们写的顺序来的，因此我们需要休眠一秒，保证t1线程执行完成
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicReference.compareAndSet(100, 2021) + "\t" + Thread.currentThread().getName() + atomicReference.get());
        }, "t2").start();

        System.out.println("==================ABA解决================");
        new Thread(() -> {
            try {
                //因为线程的执行并不是按我们写的顺序来的，因此我们需要休眠1秒，保证t3线程执行完成
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int stamp = atomicStampedReference.getStamp();
            System.out.println("当前时间戳stamp：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            int stamp2 = atomicStampedReference.getStamp();
            System.out.println("当前时间戳stamp2：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        }, "t3").start();

        new Thread(() -> {
            //先获取值
            int stamp = atomicStampedReference.getStamp();
            System.out.println("t4 stamp:" + stamp);
            try {
                //因为线程的执行并不是按我们写的顺序来的，因此我们需要休眠3秒，保证t1线程执行完成
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("更新结果为：" + atomicStampedReference.compareAndSet(
                    100, 2021, stamp, stamp + 1) + "当前值为：" + atomicStampedReference.getReference()  + "currentStamp:" + atomicStampedReference.getStamp());
        }, "t4").start();
    }
}
