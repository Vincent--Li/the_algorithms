package com.algorithm.vincent.hashcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class HashCodeLearning {

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<Person, String>();
        Person p1  = new Person("zhangsan", 1);
        Person p2  = new Person("zhangsan", 1);
        Person p3  = new Person("zhangsan", 1);

        map.put(p1, "zhangsan");
        map.put(p2, "zhangsan");
        map.put(p3, "zhangsan");

        // expected to 3, if Person class didn't overwrite hashCode, if so expeted to be 1
        System.out.println(map.entrySet().size());


        Person p4  = new Person("zhangsan", 1);
        Person p5  = new Person("lisi", 1);
        Person p6  = new Person("wangwu", 1);

        Set<Person> set = new HashSet();
        set.add(p4);
        set.add(p5);
        set.add(p6);

        // expeted to be 3
        System.out.println(set.size());
        p4.setName("lisii");
        set.remove(p4);

        // this will not remove the origin p3, because of
        // the change of property name actually cause recalculation of the hashCode
        // which lead to a miss hit on the hash map
        // expected to be 3(weird part)
        System.out.println(set.size());
        set.add(p4);

        // expected to be 4
        System.out.println(set.size());

    }
}
