package com.huhst.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author panbailiang
 * @Classname BlockingQueueDemo
 * @Date 2021/4/12 8:40 上午
 *
 * 阻塞队列
 *      ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序
 *      LinkedBlockingQueue:是一个基于链表结构的阻塞队列，此队列按FIFO（先进先出）排序元素，吞吐量通常高于
 *          ArrayBlockingQueue，
 *      SynchronousQueue:一个不存储元素的阻塞队列，每一个插入操作必须等另一个线程移除操作，否则插入一直处于
 *      阻塞状态
 *
 *
 *  阻塞队列
 *      2.1 阻塞队列有不有好的一面
 *
 *      2.2 不得不阻塞如何管理
 *      概念：
 *          当阻塞队列是空的时，从队列中获取元素的操作将会被阻塞
 *          当队列是满的时，往对列里面添加元素的操作将会被阻塞
 *
 *
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(1);
    }
}
