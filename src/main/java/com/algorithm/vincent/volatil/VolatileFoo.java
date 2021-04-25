package com.algorithm.vincent.volatil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class VolatileFoo {

    final static int MAX = 5;

    static int init_value = 0;

    static volatile int localValue = 0;

    public static void main(String[] args) {

        new Thread(()->{
            localValue = init_value;
            while(localValue < MAX){
                if(init_value != localValue){
                    System.out.printf("The init_value is updated to [%d]\n", init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();

        new Thread(()->{
            localValue = init_value;
            while(localValue < MAX){
                System.out.printf("The init_value will be changed to [%d] \n", ++localValue);
                init_value = localValue;

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }
}
