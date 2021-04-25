package com.algorithm.vincent.contextclassloader;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class MainThreadClassLoader {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
