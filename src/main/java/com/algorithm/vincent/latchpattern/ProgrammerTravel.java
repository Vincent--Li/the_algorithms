package com.algorithm.vincent.latchpattern;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ProgrammerTravel extends Thread{

    private final Latch latch;
    private final String programmer;
    private final String transportation;

    public ProgrammerTravel(Latch latch, String programmer, String transportation){
        this.latch = latch;
        this.programmer = programmer;
        this.transportation = transportation;
    }

    @Override
    public void run() {
        System.out.println(programmer + " start take the transportation [" + transportation + "]");
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt()%10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(programmer + " arried by " + transportation);
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException{
        Latch latch = new CountDownLatch(4);
        new ProgrammerTravel(latch, "Alex","Bus").start();
        new ProgrammerTravel(latch, "Gavin", "Walking").start();
        new ProgrammerTravel(latch, "Jack", "Subway").start();
        new ProgrammerTravel(latch, "Dillon", "Bicycle").start();
        try {
            latch.await(TimeUnit.SECONDS, 5);
        } catch (WaitTimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("== all of programmer arrived ==");
    }
}