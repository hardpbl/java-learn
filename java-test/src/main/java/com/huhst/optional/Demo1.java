package com.huhst.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author panbailiang
 * @Classname Demo1
 * @Date 2021/3/11 10:35 上午
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        Optional.of(objects).orElseGet(new ArrayList<String>());

    }
}
