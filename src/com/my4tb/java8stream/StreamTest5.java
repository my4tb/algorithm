package com.my4tb.java8stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 归约，即将一个流缩减成一个值，实现求和、积等操作
 */
public class StreamTest5 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);

        // 求list中元素之和
        // 方式 1
        Optional<Integer> sum1 = list.stream().reduce(Integer::sum);
        System.out.println(sum1.get());

        // 方式 2
        Integer sum2 = list.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        // 求list中元素之积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);
        System.out.println(product.get());

        // 求list中元素的最大值
        // 方式 1
        Optional<Integer> max1 = list.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println(max1.get());

        // 方式 2
        Optional<Integer> max2 = list.stream().reduce(Integer::max);
        System.out.println(max2.get());

        System.out.println("-------------------------------------------------------");

        List<Person> personList = Person.getPersonList();

        // 求所有员工的工资之和和最高工资

        // 求工资之和
        // 方式 1
        Optional<Integer> sumSalary1 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println(sumSalary1.get());

        // 方式 2
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);
        System.out.println(sumSalary2);

        // 求最高工资
        Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), Integer::max);
        System.out.println(maxSalary);

    }

}
