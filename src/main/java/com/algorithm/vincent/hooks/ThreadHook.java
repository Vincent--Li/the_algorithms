package com.algorithm.vincent.hooks;

import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ThreadHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("thread 1 is running");;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 1 exit");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("thread 2 is running");;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 2 exit");
        }));

        System.out.println("java program is going down");
    }
}
