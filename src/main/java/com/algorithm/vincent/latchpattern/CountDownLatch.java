package com.algorithm.vincent.latchpattern;

import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class CountDownLatch extends Latch{

    public CountDownLatch(int limit){
        super(limit);
    }

    @Override
    public void await() throws InterruptedException {
        synchronized (this){
            while(limit >0){
                this.wait();
            }
        }
    }

    @Override
    public void countDown() {
        synchronized (this){
            if(limit <= 0){
                throw new IllegalStateException("all of task already arrived");
            }
            limit--;
            this.notifyAll();
        }
    }

    @Override
    public int getUnarrived() {
        return limit;
    }

    @Override
    public void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeoutException {
        if(time < 0){
            throw new IllegalArgumentException();
        }
        long remainingNanos = unit.toNanos(time);
        final long endNanos = System.nanoTime() + remainingNanos;
        synchronized (this){
            while(limit >0){
                if(TimeUnit.NANOSECONDS.toMillis(remainingNanos) <= 0){
                    throw new WaitTimeoutException("Timeout");
                }
                this.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
                remainingNanos = endNanos - System.nanoTime();
            }
        }

    }


}
