package com.huhust;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author panbailiang
 * @Classname OptionalApiDemo
 * @Date 2021/4/8 4:51 下午
 */
public class OptionalApiDemo {
    public static void main(String[] args) {
        //这里ifPresent() 是将一个Lambda表达式作为输入，T值如果不为空将传入这个lambda。
        // 那么这个lambda将不为空的单词转为大写输出显示。在前面names单词流寻找结果中，
        // 有可能找不到开始字母为L的单词，返回为空，也可能找到不为空，这两种情况都传入lambda中，
        // 无需我们打开盒子自己编写代码来判断，它自动帮助我们完成了，无需人工干预。
        Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
        Optional<String> longest = names
                .filter(name -> name.startsWith("L"))
                .findFirst();
        longest.ifPresent(name -> {
            String s = name.toUpperCase();
            System.out.println("s = " + s);
        });
        String test = null;
        Optional<String> optional = Optional.ofNullable(test);
        optional.ifPresent((s) -> {
            System.out.println("s = " + s.length());
        });
        System.out.println("===============使用map()=================");
        //使用map()
        //　　如果你想从Optional<T>中返回一个值怎么办？使用 map()，如下
        Stream<String> mapStr = Stream.of("Mamurudu", "Okanbi", "Oduduwa");
        Optional<String> optionalStr = mapStr
                .filter(name -> name.startsWith("L"))
                .findFirst();

        Optional<String> stringOptional = optionalStr.map(String::toUpperCase);

        boolean present = stringOptional.isPresent();
        System.out.println("present = " + present);


        System.out.println("=============使用orElse==============");
        Stream<String> orElse = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
        Optional<String> orElseLongest = orElse
                .filter(name -> name.startsWith("Q"))
                .findFirst();
        String alternate = orElseLongest.orElse("～～～～我好像理解了～～～～");
        //prints out "Nimrod"
        System.out.println(alternate);


        System.out.println("================使用orElseGet==================");
        Stream<String> orElseGet = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
         orElseGet
                .filter(name -> name.startsWith("Q"))
                .findFirst().orElseGet(() -> {
            return "Hello lambda";
        });
//        String orElseGetResult = orElseGetLongest.orElseGet(() -> {
//            return "Hello lambda";
//        });
        System.out.println(orElseGetResult);


        System.out.println("================使用orElseThrow===============");
        Stream<String> orElseThrowNames = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
        Optional<String> orElseThrowNamesLongest = orElseThrowNames
                .filter(name -> name.startsWith("Q"))
                .findFirst();
        orElseThrowNamesLongest.orElseThrow(()-> new RuntimeException("哈哈"));

    }
}
