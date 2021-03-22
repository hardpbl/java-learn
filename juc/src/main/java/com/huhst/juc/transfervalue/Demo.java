package com.huhst.juc.transfervalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author panbailiang
 * @Classname Demo
 * @Date 2021/2/26 4:26 下午
 */
public class Demo {
    private String name;
    private Integer age;
    public Demo(String name, Integer age){
        System.out.println("正常结构");
        this.name = name;
        this.age = age;
    }
    public Demo(String name, Object... objects){
        System.out.println("可变参数");
        this.name = name;
        this.age = (Integer) objects[0];
    }

    public static void main(String[] args) {
        Demo demo = new Demo("张三",10,11);
    }
}
