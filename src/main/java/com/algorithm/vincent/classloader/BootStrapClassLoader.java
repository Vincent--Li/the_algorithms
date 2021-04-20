package com.algorithm.vincent.classloader;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class BootStrapClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
