package com.algorithm.vincent.memoization;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class Memoizer1<A,V> implements Computable<A,V> {
    private final Map<A,V> cache = new HashMap<>();
    private final Computable<A,V> c;

    public Memoizer1(Computable<A,V> c){
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException, ExecutionException {
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
