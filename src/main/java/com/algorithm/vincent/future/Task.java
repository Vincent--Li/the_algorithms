package com.algorithm.vincent.future;

/**
 * @author by zhiyuan.li@hand-china.com
 */
@FunctionalInterface
public interface Task<IN, OUT> {
    OUT get(IN input);
}
