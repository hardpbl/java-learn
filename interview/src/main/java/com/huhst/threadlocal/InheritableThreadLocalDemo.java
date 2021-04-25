package com.huhst.threadlocal;

import java.util.HashMap;

/**
 * @author panbailiang
 * @Classname InheritableThreadLocalDemo
 * @Date 2021/4/25 4:46 下午
 * 考虑这个ThreadLocal变量没有其他强依赖，如果当前线程还存在，由于线程的ThreadLocalMap里面的key是弱引用，
 * 所以当前线程的ThreadLocalMap里面的ThreadLocal变量的弱引用在gc的时候就被回收，但是对应的value还是存在
 * 的这就可能造成内存泄漏(因为这个时候ThreadLocalMap会存在key为null但是value不为null的entry项)
 *
 */
public class InheritableThreadLocalDemo {
    static ThreadLocal<HashMap<String, String>> inheritableThreadLocal = new InheritableThreadLocal();
    public static void main(String[] args) {
        //在main线程中添加main线程的本地变量
        HashMap<String, String> map = new HashMap<>(10);
        map.put("one","张三");
        inheritableThreadLocal.set(map);
        //新创建一个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程中的本地变量值:"+inheritableThreadLocal.get().get("one"));
            }
        });
        thread.start();
        //输出main线程中的本地变量值
        System.out.println("mainx线程中的本地变量值:"+inheritableThreadLocal.get().get("one"));
        inheritableThreadLocal.remove();
    }
}
