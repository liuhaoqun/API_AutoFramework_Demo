package com.faceing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Create By ${liuhaoqun} on 2021/3/10.
 */
public class DemoSort {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("a张三", 23));
        list.add(new Student("b李四", 2));
        list.add(new Student("c王五", 73));
        list.add(new Student("a张三", 5));

        System.out.println(list);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄升序排序
                int result = o1.getAge() - o2.getAge();
                //如果两个人年龄相同，再使用姓名的第一个字比较
                if (result == 0) {
                    return result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }

        });
        System.out.println(list);
    }
}
