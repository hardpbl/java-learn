package com.huhst.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname ArrayListDemo
 * @Date 2021/3/30 7:08 上午
 *
 * ArrayList  线程不安全的  add方法没有加锁  初始值默认为10
 *  List的并发修改异常的解决办法
 *  List<String> list = Collections.synchronizedList(new ArrayList<>());
 *         for (int i = 0; i < 30; i++) {
 *             new Thread(()->{
 *                 //写
 *                 list.add(UUID.randomUUID().toString());
 *                 //读
 *                 System.out.println(Thread.currentThread().getName() + "\t" + list.toString());
 *             },String.valueOf(i)).start();
 *         }
 *  方法一：
 * Vector 并发低下
 *      public synchronized boolean add(E e) {
 *         modCount++;
 *         ensureCapacityHelper(elementCount + 1);
 *         elementData[elementCount++] = e;
 *         return true;
 *     }
 *  方法二：
 *     List<String> list = Collections.synchronizedList(new ArrayList<>());
 *
 *  方法三：
 *      juc下的工具类
 *      并发争抢导致资源，导致一个线程事情还未做完就出被其他线程操作了
 *      写时复制，读写分离
 *      写时复制思想
 *       CopyOnWrite容器即写时复制容器，往一个容器内添加元素的时候，不直接往当前容器Object[]添加，而是先将当前
 *       容器Object[]进行copy，复制出一个新的容器Object[] newElements,然后在新的容器Object[] newElements里面
 *       添加元素。添加元素后，再将原容器的引用指向新的容器setArray(newElements) 这样做的好处就是可以对CopyOnWrite
 *       容器进行并发的读而不需要加锁，因为当前容器不会添加任何元素，所以CopyOnWrite容器也是一种读写分离的思想，读和写
 *       是不同的容器
 *
 *
 *
 *      public boolean add(E e) {
 *         final ReentrantLock lock = this.lock;
 *         lock.lock();
 *         try {
 *             Object[] elements = getArray();
 *             int len = elements.length;
 *             Object[] newElements = Arrays.copyOf(elements, len + 1);
 *             newElements[len] = e;
 *             setArray(newElements);
 *             return true;
 *         } finally {
 *             lock.unlock();
 *         }
 *     }
 *
 *
 *
 *
 */
public class ArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
//        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        List<String> list = new ArrayList<>();

//        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                //写
                list.add(UUID.randomUUID().toString());
                //读
                System.out.println(Thread.currentThread().getName() + "\t" + list.toString());
            },String.valueOf(i)).start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(list);

    }
}
