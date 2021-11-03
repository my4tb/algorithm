package com.my4tb.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 归集，如toList、toMap及toSet等
 */
public class StreamTest6 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);

        // 偶数元素收集到list中
        List<Integer> newList = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(newList);

        // 偶数元素收集到set中
        Set<Integer> newSet = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toSet());
        System.out.println(newSet);

        List<Person> personList = Person.getPersonList();

        // 将工资大于8k的元素映射到map中，key为name，value为salary
        Map<String, Integer> personMap =
                personList.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, Person::getSalary));
        System.out.println(personMap);

    }

}
