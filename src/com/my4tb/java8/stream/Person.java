package com.my4tb.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    private static List<Person> personList;

    static {
        personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 1, "male", "New York"));
        personList.add(new Person("Jack", 7000, 3, "male", "Washington"));
        personList.add(new Person("Lily", 7000, 2, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 4, "female", "New York"));
        personList.add(new Person("Owen", 9500, 5, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 6, "female", "New York"));
    }

    public static List<Person> getPersonList() {
        return personList;
    }

    // 构造方法
    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
