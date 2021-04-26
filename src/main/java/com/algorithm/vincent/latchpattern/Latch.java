package com.algorithm.vincent.latchpattern;

import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public abstract class Latch {
    protected int limit;

    public Latch(int limit){
        this.limit = limit;
    }

    public abstract void await() throws InterruptedException ;

    public abstract void countDown();

    public abstract int getUnarrived();

    public abstract void await(TimeUnit unit,  long time) throws InterruptedException, WaitTimeoutException;

}
