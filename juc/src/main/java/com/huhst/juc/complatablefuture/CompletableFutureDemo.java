package com.huhst.juc.complatablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author panbailiang
 * @Classname CompletableFutureDemo
 * @Date 2021/2/15 12:40 上午
 *
 * 异步回调
 *
 *
 *
 *
 *
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println();
        });
        voidCompletableFuture.get();


        CompletableFuture<String> uCompletableFuture = CompletableFuture.supplyAsync(() -> {
            int a = 10/0;
            return "1024";
        });

        uCompletableFuture.whenComplete((t, u) ->{
            System.out.println("T:" + t);
            System.out.println("U:" + u);
        }).exceptionally(f->{
            System.out.println(f.getMessage());
            return "444";
        }).get();
    }
}
