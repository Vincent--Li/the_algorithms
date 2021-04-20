package com.algorithm.vincent.threadgroup;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread testThread = new Thread(()->{
            System.out.println("testThread current threadgroup name" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread current thread name " +
                    Thread.currentThread().getName());
        });
        testThread.start();

        System.out.println("thread name for main " + Thread.currentThread().getName());
    }
}
