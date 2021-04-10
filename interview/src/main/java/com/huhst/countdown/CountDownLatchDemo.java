package com.huhst.countdown;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;

/**
 * @author panbailiang
 * @Classname CountDownLatchDemo
 * @Date 2021/4/10 2:29 下午
 *
 * 用了怎么样，不用又怎样，解决了什么问题
 *
 * 可以用来记数，countDown减少，await等待countDown减少到0的时候await阻塞结束
 *
 * 功能+性能
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "\t 被灭掉了");
            },CountDown.getInstance(i)).start();
        }
        countDownLatch.await();
        System.out.println("秦定天下");
    }
}

/**
 * @author panbailiang
 */

enum CountDown {
    One(1,"齐"),Tow(2,"楚"),Three(3,"燕"),Four(4,"韩"),Five(5,"赵"),Six(6,"魏");
    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }



    CountDown(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getInstance(int code){
        CountDown[] values = CountDown.values();
        for (CountDown value : values) {
            if (value.getCode()==code){
                return value.getMessage();
            }
        }
        return null;
    }
}

