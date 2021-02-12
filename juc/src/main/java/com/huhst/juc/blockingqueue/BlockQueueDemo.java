package com.huhst.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author panbailiang
 * @Classname BlockQueueDemo
 * @Date 2021/2/13 12:04 上午
 *
 *
 * 阻塞队列
 *      先进先出
 *
 *      必要的阻塞，不得不阻塞
 *      当队列是空的时候，获取队列的操作应该被阻塞
 *      当队列是满的时候，从队列中添加元素的操作应该被阻塞
 *
 *      ArrayBlockingQueue：由数组组成的有界阻塞队列
 *      LinkedBlockingQueue：由链表组成的有界阻塞队列（Integer.MAX_VALUE）
 *      SynchronousQueue：不存储元素的阻塞队列，只能存一个元素
 *
 *
 *      BlockQueue的核心方法
 *
 *      方法类型        抛出异常          特殊值           阻塞          超时
 *      插入            add(e)        offer(e)        put(e)         offer(e,time,unit)
 *
 *      移除            remove        poll()          take()          poll(time,unit)
 *
 *      检查            element        peek()         不可用             不可用
 *
 *      抛出异常：单阻塞队列满时，再往队列里面add插入元素会抛出java.lang.IllegalStateException: Queue full
 *              当阻塞队列空时，再往队列里面remove移除元素的时候会抛出NoSuchElementException
 *      特殊值：  插入方法，成功是true，失败false
 *               移除方法：成功返回队列的元素，队列里面没有就返回null
 *      一直阻塞：当阻塞队列满时，生产者线程继续往队列中put元素，队列会一直阻塞生产者线程直到put数据or响应中断退出
 *      当队列空时，消费者线程试图从队列里面taken元素，队列会一直阻塞消费者线程，直到队列可用
 *      超时退出：当队列满时，队列会阻塞生产者一定时间，超过限时后生产者线程会退出
 *
 *
 *
 *
 *
 *
 *
 */
public class BlockQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        boolean a = blockingQueue.add("A");
        boolean b = blockingQueue.add("B");
        boolean c = blockingQueue.add("C");
        blockingQueue.remove();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(blockingQueue.toString());

        blockingQueue.stream().forEach(s -> {
            System.out.println(s);
        });


    }
}
