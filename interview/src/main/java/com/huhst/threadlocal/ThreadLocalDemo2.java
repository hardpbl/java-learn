package com.huhst.threadlocal;

import java.util.HashMap;

/**
 * @author panbailiang
 * @Classname ThreadLocalDemo2
 * @Date 2021/4/25 4:33 下午
 *
 * ThreadLocal的不可继承性
 *      同一个ThreadLocal变量在父线程中被设置值后，在子线程中是获取不到的。（threadLocals中为当前调用线程对应的本地变量，所以二者自然是不能共享的）
 */
public class ThreadLocalDemo2 {
    //(1)创建ThreadLocal变量
    public static ThreadLocal<HashMap<String,String>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //在main线程中添加main线程的本地变量
        HashMap<String, String> map = new HashMap<>(10);
        map.put("one","张三");
        threadLocal.set(map);
        //新创建一个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程中的本地变量值:"+threadLocal.get().get("one"));
            }
        });
        thread.start();
        //输出main线程中的本地变量值
        System.out.println("mainx线程中的本地变量值:"+threadLocal.get().get("one"));
        threadLocal.remove();
    }
}
