package com.my4tb.java8stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 提取、组合22
 */
public class StreamTest11 {

    public static void main(String[] args) {

        String[] strs1 = {"a", "b", "c", "d", "e"};
        String[] strs2 = {"e", "f", "g", "h", "i"};

        Stream<String> stream1 = Stream.of(strs1);
        Stream<String> stream2 = Stream.of(strs2);

        // concat：合并两个流并去重
        System.out.println(Stream.concat(stream1, stream2).distinct().collect(Collectors.toList()));

        // limit：限制从流中获取n个元素
        System.out.println(Stream.iterate(0, x -> x + 1).limit(3).collect(Collectors.toList()));

        // skip：跳过n个元素
        System.out.println(Stream.iterate(0, x -> x + 1).skip(5).limit(3).collect(Collectors.toList()));

    }

}
