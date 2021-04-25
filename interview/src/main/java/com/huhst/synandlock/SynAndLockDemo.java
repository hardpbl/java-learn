package com.huhst.synandlock;

/**
 * @author panbailiang
 * @Classname SynAndLockDemo
 * @Date 2021/4/15 8:50 上午
 *
 * Synchronize和lock的区别
 *
 *       1。synchronize是java的关键字，属于jvm层面，
 *          基于monitorenter实现(底层是通过monitor对象来完成，其实wait和notify等方法也是依赖于monitor对象，因此我们只能在同
 *           块或方法中才能调用wait和notify等方法)
 *           monitorexis，存在两个，保证可重入锁完全释放，避免死锁
 *           而Lock是具体类，java.util.concurrent.locks.Lock,是Api层面的锁
 *       2.使用方法
 *          Synchronized不需要用户手动释放锁，当synchronized代码执行完后系统会自动让线程释放
 *          对锁的占用，Reetrantlock则不需要用户去手动释放锁若没有主动释放锁，就有可能出现死锁现象
 *           ，需要lock和unlock()方法配合try/finally语句来完成
 *       3。等待是否可以中断
 *           synchronized不可中断，除非抛出异常或者正常运行完成
 *           Reetrantlock可中断，1。设置超时方法tryLock(long timeout,TimeUnit unit)
 *                          2.lockInterruptibly()放代码块中，调用interrupt()方法可以中断
 *       4。加锁是否公平
 *          Synchronized非公平锁
 *          ReetrantLock两者都可以。默认非公平锁，构造方法可以传入boolean值，true为公平锁，false为非公平锁
 *       5。锁绑定多个条件condition
 *          Synchronized没有
 *           ReentrantLock用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized要么随机唤醒一个线程，要么
 *           唤醒全部线程
 */
public class SynAndLockDemo {
    public static void main(String[] args) {

    }
}
