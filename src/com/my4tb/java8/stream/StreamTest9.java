package com.my4tb.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 接合，joining，使用特定的字符连接元素，形成一个新的字符串
 */
public class StreamTest9 {

    public static void main(String[] args) {

        List<Person> personList = Person.getPersonList();

        // 拼接所有元素name，用逗号分隔
        String newString = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(newString);

        List<String> strs = Arrays.asList("A", "B", "C");
        System.out.println(strs.stream().collect(Collectors.joining("-")));
        System.out.println(String.join("-", strs));

    }

}
