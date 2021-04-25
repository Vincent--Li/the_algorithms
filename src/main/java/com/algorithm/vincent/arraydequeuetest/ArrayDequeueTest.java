package com.algorithm.vincent.arraydequeuetest;

import java.util.ArrayDeque;
import java.util.Deque;

import com.mysql.jdbc.Driver;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ArrayDequeueTest {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");

        deque.offerLast("e");
        deque.offerLast("f");
        deque.offerLast("g");
        deque.offerLast("h");

        deque.push("i");
        deque.offerLast("j");

        System.out.println("数据出栈:");

        while(!deque.isEmpty()){
            System.out.println(deque.pop() + "");
        }

    }

}
