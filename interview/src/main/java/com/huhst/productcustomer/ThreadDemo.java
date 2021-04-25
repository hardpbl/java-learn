package com.huhst.productcustomer;

import java.util.HashMap;

/**
 * @author panbailiang
 * @Classname ThreadDemo
 * @Date 2021/4/19 9:36 上午
 */
public class ThreadDemo {
    static HashMap<String,String> map = new HashMap<>();
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(()->{
                map.put(String.valueOf(finalI),String.valueOf(finalI));
                System.out.println(Thread.currentThread().getName()+"\t 添加了数据");
                        ;
            },"A").start();
        }

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(()->{
                String result = map.get(String.valueOf(finalI));
                System.out.println(Thread.currentThread().getName()+"\t 获取了数据：" + result);
            },"B").start();
        }

    }
}
