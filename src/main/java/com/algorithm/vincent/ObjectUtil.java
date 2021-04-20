package com.algorithm.vincent;

import java.util.Objects;

import com.algorithm.vincent.hashcode.Person;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ObjectUtil {

    public static void main(String[] args) {

        Person person = new Person("test", 12);
        Person person1 = new Person("test", 12);
        System.out.println(Objects.equals(person, person1));
    }
}
