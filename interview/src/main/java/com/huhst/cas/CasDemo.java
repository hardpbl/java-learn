package com.huhst.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author panbailiang
 * @Classname CasDemo
 * @Date 2021/3/28 2:58 下午
 *
 * CAS是什么
 *      比较并交换
 *      真实值和期望值相同，则可以更新需要的数据，否则更新失败
 *      AtomicInteger是如何解决i++的问题的
 *          unsafe
 *          cas思想(自旋锁)
 *
 *          public final int getAndIncrement() {
 *               return unsafe.getAndAddInt(this, valueOffset, 1);
 *          }
 *          sun.misc
 *              valueOffset 内存地址偏移量
 *
 *           public final int getAndAddInt(Object var1, long var2, int var4) {
 *              int var5;
 *              do {
 *                   var5 = this.getIntVolatile(var1, var2);
 *              } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
 *
 *              return var5;
 *              }
 *
 *    CAS的缺点
 *      1。循环时间长，
 *      2。只能保证一个变量
 *      3。ABA问题
 *      CAS->UNSAFE->CAS底层思想->ABA->原子引用更新->如何规避ABA问题
 *
 *      Cas导致的ABA问题
 *               狸猫换太子
 *          A，B两线程都操作一个变量，原值是2，B期望值是2，更新值又是2，对于A而言期望值还是2，A就会认为这个值
 *          没有动过，可以正常更新，即使在A之前更新了n多次，虽然A整个过程是成功的，但是不代表A过程是没有问题的。
 *
 *
 *
 *
 *
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.compareAndSet(5, 2021) + "\t" + "current value:" + atomicInteger.get() );
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t" + "current value:" + atomicInteger.get() );

    }
}
