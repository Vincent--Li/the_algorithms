package com.algorithm.vincent.memoization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class Memoizer2<A,V> implements Computable<A,V> {
    private final Map<A,V> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> c;

    public Memoizer2(Computable<A,V> computable){
        this.c = computable;
    }

    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
    @Override
    public int getCacheSize(){
        return cache.size();
    }
}
