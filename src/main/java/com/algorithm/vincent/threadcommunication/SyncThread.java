package com.algorithm.vincent.threadcommunication;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class SyncThread implements Runnable {
    private static int count;
    private static String lock = "lock";
    public SyncThread() {
        count = 0;
    }

    public void run() {
        synchronized (lock) {
            System.out.printf( Thread.currentThread().getName() + "enter ");
            try {
                lock.wait(10*1000);
                System.out.println("test " + Thread.currentThread().getName() );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
    }
}

