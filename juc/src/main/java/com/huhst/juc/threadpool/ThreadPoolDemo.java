package com.huhst.juc.threadpool;

import sun.jvm.hotspot.runtime.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname ThreadPoolDemo
 * @Date 2021/2/14 3:44 下午
 * <p>
 * 少new且能复用，减少上下文的切换
 * <p>
 * 线程池的优势
 * 1.线程池做的工作主要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，如果
 * 线程的数量超过了最大的数量，超出的线程数量就需要排队等候，等待其他线程执行完毕，然后再从队列中取出任务来
 * 进行执行
 * <p>
 * 它的主要特点是：线程复用，控制最大并发数，管理线程
 * <p>
 * 第一：降低资源的消耗，通过重复利用已创建的线程来降低线程创建和销毁造成的消耗
 * 第二：提高响应速度，当任务到达的时候不需要等待线程创建就能立即执行
 * 第三：提高线程的可管理性，线程是稀缺资源，如果无限制创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池
 * 可以进行统一的分配，调优和监控
 * <p>
 * Executor  父接口
 * ExecutorService
 * <p>
 * ThreadPoolExecutor
 * <p>
 * 主要是这三个
 * Executors.newFixedThreadPool(5)  //五个受理线程  指定数量的线程池
 * Executors.newSingleThreadExecutor //单个的线程池
 * newCachedThreadPool  //自动扩容
 * <p>
 * 底层来自于通过ThreadPoolExecutor实现
 * <p>
 * //五个受理线程  指定数量的线程池
 * ExecutorService executorService = Executors.newCachedThreadPool();
 * for (int i = 1; i <= 10 ; i++) {
 * executorService.execute(()->{
 * System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
 * });
 * }
 * <p>
 * 线程池中的七大参数
 * <p>
 * public ThreadPoolExecutor(int corePoolSize,
 * int maximumPoolSize,
 * long keepAliveTime,
 * TimeUnit unit,
 * BlockingQueue<Runnable> workQueue) {
 * this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
 * Executors.defaultThreadFactory(), defaultHandler);
 * }
 * <p>
 * 1.corePoolSize：线程池中的常驻核心线程数
 * 2.maximumPoolSize：线程池中能够容纳的同时执行的最大线程数，此值必须大于1
 * 3.keepAliveTime：多余的空闲线程存活时间，当前池中线程数量超过corePoolSize时，当空闲
 * 时间达到keepAliveTime时，多余线程会被销毁直到只剩下corePoolSize个线程为止
 * 4.unit：keepAliveTime的单位
 * 5.workQueue:任务队列，被提交但尚未被执行的任务
 * 6.threadFactory:表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认即可
 * 7.handler:拒绝策略，表示当队列满了，并且工作线程大于等于线程池的最大线程数(maximumPoolSize)时如何来
 * 拒绝请求执行的runnable的策略
 * <p>
 * <p>
 * <p>
 * 原理+方法论+思想
 * <p>
 * 银行的候客区就是我们的阻塞队列
 * <p>
 * <p>
 * 线程池用哪一个，如何设置线程池参数
 * <p>
 * 线程池中的拒绝策略
 * 什么时候起作用：
 * 等待队列排满了，再也塞不下新的任务了，同时线程池重的max线程数也达到了最大，无法继续为新任务服务
 * 这个时候我们就需要拒绝策略机制合理的处理这个问题
 * <p>
 * AbortPolicy(默认)：直接抛出RejectedExecutionException异常，阻止系统正常运行
 * CallerRunPolicy："调用者运行"-一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退
 * 到调用者，从而降低新任务的流量 //回退机制，谁让你找我的你找谁
 * DiscardPolicy：抛弃处理不掉的,该策略默默的丢弃无法处理的任务，不予任何处理也不抛出异常，
 * 如果允许任务丢失，这是最好的一种策略
 * DiscardOldestPolicy: 抛弃队列中等待最久的任务，然后把当前任务加入到队列中尝试再次提交当前任务
 * <p>
 * ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 2,
 * TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),
 * new ThreadPoolExecutor.DiscardOldestPolicy());
 * for (int i = 1; i <= 10; i++) {
 * threadPoolExecutor .execute(() -> {
 * System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
 * });
 * }
 * <p>
 * <p>
 * 线程数的配置：
 * cpu密集型：最大核心数=逻辑处理核心数+1
 * IO密集型：cpu核心数
 *
 *
 *
 *
 * <p>
 * <p>
 * 自定义线程池
 * 最大容纳数=最大数+队列数
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

    }
}
