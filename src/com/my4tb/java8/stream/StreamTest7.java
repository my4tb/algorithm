package com.my4tb.java8.stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 统计
 */
public class StreamTest7 {

    public static void main(String[] args) {

        List<Person> personList = Person.getPersonList();

        // 统计元素总数
        Long count = personList.stream().collect(Collectors.counting());
        System.out.println("元素总数：" + count);

        // 求平均工资
        Double averageSalary = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println(averageSalary);

        // 求最高工资持有者的姓名
        Optional<Person> person = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println(person.get().getName());

        // 求最高工资
        Optional<Integer> maxSalary = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(maxSalary.get());

        // 求工资之和
        Integer sumSalary = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        System.out.println(sumSalary);

        // 一次性统计所有信息
        IntSummaryStatistics allInformation = personList.stream().collect(Collectors.summarizingInt(Person::getSalary));
        System.out.println(allInformation);

    }

}
