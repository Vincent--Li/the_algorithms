package com.algorithm.vincent.threadsafecounter;

import lombok.Synchronized;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public final class Counter {
    private Long value = 0L;

    public synchronized long getValue(){
        return this.value;
    }

    public synchronized long increment(){
        return this.value++;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i< 50000; i++){
                    counter.increment();
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i< 50000; i++){
                    counter.increment();
                }
            }
        };

        Thread t3 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i< 50000; i++){
                    counter.increment();
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println(counter.getValue());



    }
}
