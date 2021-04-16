package com.huhst.day02;

/**
 * @author panbailiang
 * @Classname Demo
 * @Date 2021/3/31 10:22 下午
 */
public class Demo {
    final static String MES_WMS = "M";
    static {
        int a =10;
    }
    int age;
    public static void main(String[] args) {
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
    }
}
