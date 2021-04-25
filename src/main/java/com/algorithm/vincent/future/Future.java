package com.algorithm.vincent.future;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public interface Future<T> {
    T get() throws InterruptedException;
    boolean done();
}
