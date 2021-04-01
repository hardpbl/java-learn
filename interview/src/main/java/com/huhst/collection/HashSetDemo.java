package com.huhst.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author panbailiang
 * @Classname HashSetDemo
 * @Date 2021/3/30 6:57 上午
 *
 * 并发修改异常
 *
 * 模拟并发修改异常
 *
 * hashSet如何检查重复
 *      当你把对象加入HashSet时，HashSet会先计算对象的hashcode值来判断对象加入的位置，
 *  同时也会与其他加入的对象的hashcode值作比较，如果没有相符的hashcode，HashSet会假设对象没有重复出现。
 *  但是如果发现有相同hashcode值的对象，这时会调用equals（）方法来检查hashcode相等的对象是否真的相同。
 *  如果两者相同，HashSet就不会让加入操作成功。
 *
 *  ==与equals的区别
 *
 * ==是判断两个变量或实例是不是指向同一个内存空间 equals是判断两个变量或实例所指向的内存空间的值是不是相同
 * ==是指对内存地址进行比较 equals()是对字符串的内容进行比较
 * ==指引用是否相同 equals()指的是值是否相同
 *
 *
 *
 * public static void main(String[] args) {
 *         HashSet<String> hashSet = new HashSet<>();
 *         for (int i = 0; i < 30; i++) {
 *             new Thread(()->{
 *                 //写
 *                 hashSet.add(UUID.randomUUID().toString());
 *                 //读
 *                 System.out.println(hashSet);
 *             },String.valueOf(i)).start();
 *         }
 *     }
 * 解决方式一：
 * Set<String> hashSet = Collections.synchronizedSet(new HashSet<>());
 *         for (int i = 0; i < 30; i++) {
 *             new Thread(()->{
 *                 //写
 *                 hashSet.add(UUID.randomUUID().toString());
 *                 //读
 *                 System.out.println(hashSet);
 *             },String.valueOf(i)).start();
 *         }
 * 解决方式二：并发包下的
 * Set<String> hashSet = new CopyOnWriteArraySet<>();
 *         for (int i = 0; i < 30; i++) {
 *             new Thread(()->{
 *                 //写
 *                 hashSet.add(UUID.randomUUID().toString());
 *                 //读
 *                 System.out.println(hashSet);
 *             },String.valueOf(i)).start();
 *         }
 *
 * CopyOnWriteArraySet底层基于CopyOnWriteArrayList实现
 * public CopyOnWriteArraySet() {
 *         al = new CopyOnWriteArrayList<E>();
 *     }
 *
 *    HashSet的底层是HashMap，为什么add能一个元素的时候，vlue是一个叫present的Objec类型的常量
 *
 *
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                //写
                hashSet.add(UUID.randomUUID().toString());
                //读
                System.out.println(hashSet);
            },String.valueOf(i)).start();
        }
    }
}
