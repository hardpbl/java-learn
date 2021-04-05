package com.huhst.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author panbailiang
 * @Classname HashMapDemo
 * @Date 2021/3/30 8:11 上午
 *
 * HashMap 线程不安全的 支持键为null的情况，hashTable不支持键是空的情况，若出现则会出现NPE问题
 *
 * jdk1.7
 * https://snailclimb.gitee.io/2019/08/21/java/java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6/%E5%85%A8%E7%BD%91%E9%98%85%E8%AF%BB%E8%BF%8720k%E7%9A%84Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98%E6%80%BB%E7%BB%93%EF%BC%81/
 *
 *
 *https://zhuanlan.zhihu.com/p/21673805
 *
 * push多个key为null的数据会进行覆盖，只有最后一个会生效
 * HashMap<String, Integer> map = new HashMap<>(16);
 *         map.put(null,1);
 *         map.put(null,2);
 *         map.put(null,3);
 *         System.out.println(map.toString());
 *
 *
 *  HashMap的理解
 *
 */

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
    }
}
