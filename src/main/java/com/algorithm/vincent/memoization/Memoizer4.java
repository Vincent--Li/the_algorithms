package com.algorithm.vincent.memoization;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class Memoizer4<A,V> implements Computable<A,V> {
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> c;

    public Memoizer4(Computable<A,V> computable){
        this.c = computable;
    }

    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        Future<V> f = cache.get(arg);
        if(f == null){
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> futureTask = new FutureTask<>(eval);
            f = futureTask;
            cache.putIfAbsent(arg, futureTask);
            futureTask.run();
        }
        return f.get();
    }
    @Override
    public int getCacheSize(){
        return cache.size();
    }
}