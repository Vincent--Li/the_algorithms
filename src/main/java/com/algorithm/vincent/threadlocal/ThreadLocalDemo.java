package com.algorithm.vincent.threadlocal;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ThreadLocalDemo {
    static class ThreadA implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadA(ThreadLocal<String> threadLocal){
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread A output: " + threadLocal.get());
            threadLocal.remove();
        }
    }

    static class ThreadB implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadB(ThreadLocal<String> threadLocal){
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("B");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread B output: " + threadLocal.get());
            threadLocal.remove();
        }
    }

    static class ThreadC implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadC(ThreadLocal<String> threadLocal){
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("C");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread C output: " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        new Thread(new ThreadA(threadLocal)).start();
        new Thread(new ThreadB(threadLocal)).start();
        new Thread(new ThreadC(threadLocal)).start();
    }
}
