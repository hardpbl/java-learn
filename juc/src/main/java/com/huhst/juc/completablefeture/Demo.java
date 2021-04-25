package com.huhst.juc.completablefeture;

import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname Demo
 * @Date 2021/4/23 1:02 上午
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        //求出现在的秒
        TimeUnit.SECONDS.sleep(3);

        long end = System.currentTimeMillis();
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        System.out.println((end-start));
    }
}
