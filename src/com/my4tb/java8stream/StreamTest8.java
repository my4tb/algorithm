package com.my4tb.java8stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分组
 */
public class StreamTest8 {

    public static void main(String[] args) {

        List<Person> personList = Person.getPersonList();

        // 将元素按照薪资是否高于8000分为两个部分
        Map<Boolean, List<Person>> groupBySalary = personList.stream().collect(Collectors.partitioningBy(person -> person.getSalary() > 8_000));
        System.out.println(groupBySalary);

        // 将元素按照性别分组
        Map<String, List<Person>> groupBySet = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(groupBySet);

        // 先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println(group);

    }

}
