package com.huhst.juc.collection;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author panbailiang
 * @Classname NotSafeDemo
 * @Date 2021/2/10 9:16 下午
 * <p>
 * 线程不安全  ArrayList线程不安全的
 * java.util.ConcurrentModificationException
 * 解决方法：
 * 1.Vector线程安全的，效率低下,add使用sync修饰
 * 2.Collections.synchronizedList(new ArrayList<>()) list转为线程安全的list
 * 3.CopyOnWriteArrayList
 * 写时复制-读写分离  Arrays.copyOf  每次+1
 *
 * CopyOnWrite容器既写时复制容器，往一个同期内添加元素的时候，不直接往Object[]添加，而是先将当前容器
 * 拷贝出一个新的容器Object[] newElement,然后往新的容器里面添加元素，添加完元素后再将原容器的引用指向
 * 新的容器setArray(newElement),这样做的好处就是可以对CopyOnWrite容器进行并发的读而不需要加锁，因为
 * 我们当前容器没有添加任何元素，所以CopyOnWrite也是一种读写分离思想，读和写是不同的容器
 *
 * hashMap 数组+链表+红黑树
 *
 */
public class NotSafeDemo {
    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("A", "B", "C", "D");
//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//        }
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            //一边读一边写
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 10));
                System.out.println(list);
            }, Thread.currentThread().getName()).start();

        }

    }
}
