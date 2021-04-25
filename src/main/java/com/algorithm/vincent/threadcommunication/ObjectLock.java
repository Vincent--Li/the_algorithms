package com.algorithm.vincent.threadcommunication;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ObjectLock {
    private static Object lock = new Object();
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0; i< 5; i++){
                    System.out.println("Thread A " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock){
                for(int i = 0; i < 5; i++){
                    System.out.println("Thread B " + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }
}
