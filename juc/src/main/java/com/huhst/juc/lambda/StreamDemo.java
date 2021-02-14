package com.huhst.juc.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author panbailiang
 * @Classname StreamDemo
 * @Date 2021/2/14 11:17 下午
 *
 * 四大默认函数式接口：
 *  Function(函数型接口): 传入一个T类型，返回一个R类型
 *      @FunctionalInterface
 *      public interface Function<T, R>
 *  Predicate(断定型接口):判定类型为T的对象是否满足某约束，并返回boolean值
 *
 *  Consumer(消费型接口) 对参数类型为T类型参数进行操作
 *
 *  Supplier(供给型接口) 参数:无 返回类型为T类型的对象
 *
 *
 *
 */
public class StreamDemo {
    public static void main(String[] args) {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };
        System.out.println(function.apply("123"));

        //函数型改写
        Function<String, Integer> function1 = String::length;
        System.out.println(function1.apply("ABCD"));


        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

        //断定型改写
        Predicate<String> predicate1 = String::isEmpty;
        System.out.println(predicate1.test("AAA"));

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        //消费型改写
        Consumer<String> consumer1 =s -> System.out.println(s.length());
        consumer1.accept("ANCDAS");

        //供给型
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hello world!";
            }
        };
        System.out.println(supplier.get());

        //改写
        Supplier<String> supplier1 = ()->{return "hello world";};
        System.out.println(supplier1.get());
    }
}
