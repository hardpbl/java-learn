package com.huhst.juc.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author panbailiang
 * @Classname StreamDemo
 * @Date 2021/2/14 11:55 下午
 * <p>
 * Stream流到底是什么：
 * 是数据渠道，用于操作数据源(集合，数组)等所生成的元素序列
 * 集合讲的是数据，流讲的是计算
 * <p>
 * 延迟执行：需要结果的时候才进行计算
 * 阶段：
 * 创建一个stream流->中间操作->终止操作
 * <p>
 * map:映射
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AAAA", "AB", "CDE", "D");
        //filter就是一个函数式接口，因此我们需要传一个lambda表达式进去
        List<String> a = list.stream().filter(s -> {
            return s.length() > 1;
        }).filter(s -> s.contains("A")).collect(Collectors.toList());
        System.out.println(a.toString());


        List<String> list2 = Arrays.asList("1", "2", "3", "4");

        List<Integer> collect = list2.stream().map(s -> Integer.parseInt(s) * 2).sorted((Integer::compareTo)).collect(Collectors.toList());
        System.out.println(collect.toString());
    }
}
