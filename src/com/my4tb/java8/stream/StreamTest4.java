package com.my4tb.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 映射
 */
public class StreamTest4 {

    public static void main(String[] args) {

        // 英文字符串映射为大写
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        System.out.println(Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList()));

        // 整数数组每个元素加三
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        System.out.println(intList.stream().map(num -> num + 3).collect(Collectors.toList()));

        List<Person> personList = Person.getPersonList();
        // 所有员工薪资增加一千，但不改变原集合元素
        List<Person> newPersonList = personList.stream()
                .map(person -> new Person(person.getName(), person.getSalary() + 1000, person.getAge(), person.getSex(), person.getArea()))
                .collect(Collectors.toList());
        System.out.println("增加前：" + personList.get(0).getSalary());
        System.out.println("增加后：" + newPersonList.get(0).getSalary());

        System.out.println("---------------------------------------------------");

        // 所有员工薪资增加一千，改变原集合元素
        List<Person> newPersonList1 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("增加前：" + personList.get(0).getSalary());
        System.out.println("增加后：" + newPersonList1.get(0).getSalary());

        // 将两个字符数组合并成一个新的字符数组
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> newList = list.stream().flatMap(string -> {
            String[] strings = string.split(",");
            return Arrays.stream(strings);
        }).collect(Collectors.toList());
        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + newList);

    }

}
