package com.my4tb.java8stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 筛选
 */
public class StreamTest2 {

    public static void main(String[] args) {

        List<Person> personList = Person.getPersonList();

        // 筛选集合中工资大于8k的员工，并形成新的集合
        List<String> nameList = personList.stream()
                .filter(person -> person.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());

        System.out.println("工资大于8k的员工姓名：" + nameList);

    }

}
