package com.algorithm.vincent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger tmp = new AtomicInteger();
        tmp.getAndAdd(5);
    }
}
