package com.huhst.valitale;

/**
 * @author panbailiang
 * @Classname SingletonDemo
 * @Date 2021/3/27 6:44 下午
 *
 *  多线程情况下单例模式的错误执行
 *      0构造方法
 *      3构造方法
 *      2构造方法
 *      1构造方法
 *
 *      优化一：
 *          双端检查机制
 *           if (singletonDemo == null) {
 *             synchronized (SingletonDemo.class) {
 *                 if (singletonDemo == null) {
 *                     singletonDemo = new SingletonDemo();
 *                 }
 *             }
 *         }
 *         可能在某一次调用因为指令重排存在问题，即还没有初始化就被返回了，因此我们要加上volitale，保证代码顺序的执行
 *
 */
public class SingletonDemo {
    private volatile static SingletonDemo singletonDemo;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "构造方法");
    }

    public static SingletonDemo getInstance(){
        if (singletonDemo == null) {
            synchronized (SingletonDemo.class) {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
