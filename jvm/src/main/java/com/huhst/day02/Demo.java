package com.huhst.day02;

/**
 * @author panbailiang
 * @Classname Demo
 * @Date 2021/3/31 10:22 下午
 */
public class Demo {
    public static void main(String[] args) {
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
    }
}
