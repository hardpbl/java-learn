package com.huhust;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author panbailiang
 * @Classname OperationLambdaDemo
 * @Date 2021/4/9 10:01 上午
 */
public class OperationLambdaDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(20,"YHJ"));
        personList.add(new Person(21,"JYM"));
        personList.add(new Person(22,"SJJ"));
        List<Me> meList = null;
//        Optional<List<Person>> personList2 = Optional.ofNullable(personList);
//        personList2.ifPresent(people -> {
//            people.stream().forEach(person -> {
//                Me me = new Me();
//                me.setAge(person.getAge());
//                me.setName(person.getName());
//                me.setSex(true);
//                meList.add(me);
//            });
//        });
//        List<Me> meList1 = Optional.ofNullable(meList).orElseThrow(() -> new RuntimeException("数据不存在"));
//        System.out.println("meList1 = " + meList1.toString());
        Optional.ofNullable(personList).ifPresent(personList1 -> {
            personList1.forEach(person -> {
//                Optional.ofNullable(person.getLineList()).ifPresent(mes -> {
//                    mes.forEach(System.out::println);
//                });
                person.getLineList().forEach(System.out::println);
            });
        });
        personList.forEach(person -> p);
        Optional.ofNullable(personList).orElseThrow(()->new RuntimeException("空"));

//        getList();

    }

    private static List<Me> getList(){
        List<Me> meList = null;
        return Optional.ofNullable(meList).orElseThrow(() -> new RuntimeException("数据不存在"));
    }
}

@Data
class Person{
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    List<Me> lineList = new ArrayList<>();
}

@Data
class Me{
    private Integer age;
    private String name;
    private Boolean sex;
}
