package com.my4tb.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 集合的遍历和匹配
 */
public class StreamTest1 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出每个符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);

        System.out.println("-----------------------------");

        // 匹配第一个满足条件的元素
        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
        first.ifPresent(System.out::println);

        System.out.println("-----------------------------");

        // 匹配任意满足条件的元素（适用于并行处理）
        Optional<Integer> any = list.parallelStream().filter(x -> x > 6).findAny();
        any.ifPresent(System.out::println);

        System.out.println("-----------------------------");

        // 判断是否存在满足条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println(anyMatch);

    }

}
