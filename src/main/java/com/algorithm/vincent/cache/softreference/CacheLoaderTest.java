package com.algorithm.vincent.cache.softreference;

import java.util.concurrent.TimeUnit;

import com.algorithm.vincent.cache.Reference;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CacheLoaderTest {
    public static void main(String[] args) throws InterruptedException {
        SoftLRUCache<Integer, Reference> cache = new SoftLRUCache<>(1000, key-> new Reference());
        System.out.println(cache);
        for(int i = 0; i< Integer.MAX_VALUE; i++){
            cache.get(i);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The " + i + " reference stored at cache.");
        }

    }
}
