package com.algorithm.vincent.future;

/**
 * @author by zhiyuan.li@hand-china.com
 */
@FunctionalInterface
public interface Callback<T> {
    void call(T t);
}
