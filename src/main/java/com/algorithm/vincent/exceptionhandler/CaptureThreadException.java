package com.algorithm.vincent.exceptionhandler;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CaptureThreadException {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e)->{
            System.out.println(t.getName() + " occur exception");
            e.printStackTrace();
        });
        new Thread(()->{
            System.out.println(1/0);
        }, "TestThread").start();
    }
}
