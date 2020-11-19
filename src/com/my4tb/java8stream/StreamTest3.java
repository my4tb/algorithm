package com.my4tb.java8stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 聚合，如max、min和count等
 */
public class StreamTest3 {

    public static void main(String[] args) {

        // 找出集合元素中长度最大的字符串
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        max.ifPresent(System.out::println);

        // 获取集合中的最大值
        List<Integer> integerList = Arrays.asList(7, 6, 9, 4, 11, 6);
        // 自然排序
        System.out.println("自然排序最大值：" + integerList.stream().max(Integer::compareTo).get());
        // 自定义排序，找最小值元素
        System.out.println("自定义排序最大值：" + integerList.stream().max(((o1, o2) -> o2 - o1)).get());

        // 获取员工工资最高的人
        List<Person> personList = Person.getPersonList();
        System.out.println(personList.stream().max(Comparator.comparingInt(Person::getSalary)).get().getName());

        // 计算integerList中值大于6的元素个数
        System.out.println(integerList.stream().filter(x -> x > 6).count());

    }

}
