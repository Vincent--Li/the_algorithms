package com.algorithm.vincent.threadgroup;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ThreadGroupCommonExceptionHandle {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("group1"){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        Thread thread1 = new Thread(threadGroup1, new Runnable(){
            @Override
            public void run() {
                throw new RuntimeException("testing the exception");
            }
        });

        thread1.start();
    }
}
