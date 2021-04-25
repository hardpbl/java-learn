package com.huhst.juc.collection;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author panbailiang
 * @Classname NotSafeSetDemo
 * @Date 2021/2/10 10:02 下午
 *
 * hashSet的底层对象是hashMap,key就是hashSet的值，value是一个new Object()类型的产量
 *
 * hashMap线程不安全，同时读同时写
 *
 * 自己做脑图，每周总结 可量化  懂的，半解的，完全不懂的
 *
 * ArrayList有序有重复
 * HashSet,HashMap是无序无重复，
 * ConcurrentHashMap
 *
 * 数组+链表+红黑sd
 * new HashMap()  => 默认 16 负载0.75
 * 数组里面存的是node节点
 * 高位运算后，equals key相等，则覆盖，不相等且hash冲突则变成单项链表
 * 直到8的时候就会变成红黑树
 *
 *
 *
 *
 *
 *
 */
public class NotSafeSetDemo {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        Map<String,String> map = new ConcurrentHashMap<>(16);

        for (int i = 1; i <= 30; i++) {
            //一边读一边写
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 10));
                System.out.println(set);
            }, Thread.currentThread().getName()).start();

        }
    }
}
