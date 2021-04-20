package com.algorithm.vincent.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author by zhiyuan.li@hand-china.com
 */

@Slf4j
public class BlockedTest {

    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable(){
            @Override
            public void run() {
                testMethod();
            }
        }, "a");

        Thread b = new Thread(new Runnable(){
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        Thread.sleep(1000L);
        b.start();

        log.info(a.getName() + ":" + a.getState());
        log.info(b.getName() + ":" + b.getState());
    }

    private synchronized void testMethod(){
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
