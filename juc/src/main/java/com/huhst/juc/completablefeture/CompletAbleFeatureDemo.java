package com.huhst.juc.completablefeture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author panbailiang
 * @Classname CompletAbleFeature
 * @Date 2021/4/22 8:04 下午
 */
public class CompletAbleFeatureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        CompletableFuture voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            Integer i = 10 / 2;
//            System.out.println("运行结果:" + i);
//            return ;
//        },executorService);
//        voidCompletableFuture.get();
//        System.out.println(Thread.currentThread().getName());
//
//

        /**
         * whenComplete 可以处理异常和正常的计算结果，exceptionally处理异常情况
         * whenComplete和whenCompleteAsync的区别
         *
         *  whenComplete:是执行单前任务的线程继续执行whenComplete的任务
         *  whenCompleteAsync：是把这个任务提交给线程池，由线程池来决定哪个线程执行方法
         *
         *  总结：
         *      方法不以Async结尾，意味着Action使用相同的线程来执行，而Async可能会使用线程池中其他线程来执行
         */
//        CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            int i = 10 / 0;
//            System.out.println("i = " + i);
//            return i;
//        }, executorService).whenComplete((t, e) -> {
//            //能拿到异常信息，无法返回默认值
//            System.out.println("结果result:" + t + "异常信息是：" + e);
//        }).exceptionally(throwable -> {
//            //可以感知到异常，并且返回默认值
//            return 10;
//        });
//        System.out.println(exceptionally.get());
//        exceptionally.isDone();
//
//

        /**
         * thenApplyAsync: 能接收上一步返回结果，并且有返回值
         * thenAcceptAsync:能接收上一步返回结果，无返回值
         */
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            return 0;
//        }, executorService).thenApplyAsync(res -> {
//            return res + "hello CompletableFuture";
//        }, executorService);
//        System.out.println(completableFuture.get());

        CompletableFuture<Integer> feture01 = null;

//                CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "进来了");
//            System.out.println("");
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "准备离开了");
//            return 0;
//        }, executorService);

        CompletableFuture<String> feture02 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "hello";
        }, executorService);

        CompletableFuture<String> feture03 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "world";
        }, executorService);

        //feture01和feture02任意一个任务执行完成，执行第三个任务
//        feture01.runAfterEitherAsync(feture02,()->{
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("执行任务三");
//        },executorService);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(feture01, feture02, feture03);
        voidCompletableFuture.get();
        System.out.println("feture全部执行完成：开始执行主线程" + Thread.currentThread().getName());


    }
}
