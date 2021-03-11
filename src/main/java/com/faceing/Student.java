package com.faceing;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */
public class Student {

    String name;
    int age;

    //重写
    @Override
    public String toString() {
        //return "Student{"+  "name='" +name +"'\'" +",age+'"+age+"'}";
        return name + age;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }
}
