package com.algorithm.vincent.cache.strongreference;

import com.algorithm.vincent.cache.Reference;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CacheLoaderTest {
    public static void main(String[] args) {
        LRUCache<String, Reference> cache = new LRUCache<>(5, key-> new Reference());
        cache.get("Alex");
        cache.get("Jack");
        cache.get("Gavin");
        cache.get("Dillon");
        cache.get("Leo");

        cache.get("Jenny");
        System.out.println(cache.toString());
    }
}
