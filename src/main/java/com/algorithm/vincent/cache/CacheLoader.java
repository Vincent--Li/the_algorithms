package com.algorithm.vincent.cache;

/**
 * @author by zhiyuan.li@hand-china.com
 */
@FunctionalInterface
public interface CacheLoader<K, V> {
    V load(K k);
}
