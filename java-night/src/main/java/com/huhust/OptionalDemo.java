package com.huhust;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author panbailiang
 * @Classname OptionalDemo
 * @Date 2021/4/7 11:00 上午
 */
public class OptionalDemo {
    public static void main(String[] args) throws Exception{
        FunctionDemo.Person person = null;
        //Optional.of() 如果空就直接抛出空指针异常
//        Optional<FunctionDemo.Person> person1 = Optional.of(person);
//        System.out.println("person1 = " + person1);
        //Optional.ofNullable()  可以接收一个为空的对象，返回一个option实例
        Optional<FunctionDemo.Person> person2 = Optional.ofNullable(person);
//        System.out.println(person1.get().getSex());
        System.out.println("person2.map(FunctionDemo.Person::getAge) = " + person2.map(FunctionDemo.Person::getAge));
        System.out.println("person2.map(FunctionDemo.Person::getAge) = " + person2.map(FunctionDemo.Person::getAge));
        Thread.currentThread().getName();
        try {
            person2.orElseThrow(()->{throw new RuntimeException("空的，哈哈");});
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
