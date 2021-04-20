package com.algorithm.vincent.thread;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class Demo {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            Thread thread = new Thread(()->{
                System.out.println("TEST");
            });
            thread.start();
        }
    }
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
    }

}
