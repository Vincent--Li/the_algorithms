package com.algorithm.vincent.memoization;

import java.util.concurrent.ExecutionException;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public interface Computable <A,V>{
    V compute(A arg) throws InterruptedException, ExecutionException;
    int getCacheSize();
}
