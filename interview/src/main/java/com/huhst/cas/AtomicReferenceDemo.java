package com.huhst.cas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author panbailiang
 * @Classname AtomicReferenceDemo
 * @Date 2021/3/28 11:43 下午
 *
 * 原子引用
 *
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zs = new User("zs", 20);
        User lisi = new User("lisi", 21);
        AtomicReference<User> objectAtomicReference = new AtomicReference<>();
        objectAtomicReference.set(zs);
        System.out.println(objectAtomicReference.compareAndSet(zs, lisi) + "\t" + objectAtomicReference.get().toString());
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private Integer age;
}
