package com.huhst.juc.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author panbailiang
 * @Classname AqsDemo
 * @Date 2021/6/13 9:36 上午
 * <p>
 * <p>
 * AQS=state+CLH
 */
public class AqsDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {

            Condition condition = lock.newCondition();
//

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}
