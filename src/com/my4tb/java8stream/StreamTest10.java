package com.my4tb.java8stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 排序
 */
public class StreamTest10 {

    public static void main(String[] args) {

        List<Person> personList = Person.getPersonList();

        // 按照工资升序排序，依次输出姓名
        List<String> sortedNames = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        System.out.println(sortedNames);

        // 按照工资的降序排序，依次输出姓名
        List<String> sortedNamesReversed = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        System.out.println(sortedNamesReversed);

        // 先按工资再按年龄自然排序
        List<String> sortedNamesBySalaryAndAge = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary())
                return p1.getAge() - p2.getAge();
            else
                return p1.getSalary() - p2.getSalary();
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println(sortedNamesBySalaryAndAge);

    }

}
