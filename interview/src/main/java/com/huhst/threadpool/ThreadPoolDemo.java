package com.huhst.threadpool;

/**
 * @author panbailiang
 * @Classname ThreadPoolDemo
 * @Date 2021/4/26 8:15 上午
 *
 *  线程池设置合理的线程数
 *      Cpu密集型  核数+1
 *      IO密集型
 *
 *
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
    }
}
