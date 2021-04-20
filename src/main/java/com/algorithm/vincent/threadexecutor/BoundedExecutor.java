package com.algorithm.vincent.threadexecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * @author by zhiyuan.li@hand-china.com
 * 如果没有设置Executor的拒绝策略的时候, 我们可以结合semaphore来使用
 */
public class BoundedExecutor {
    private final Executor exec;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec, int bound) {
        this.exec = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(Runnable runnable) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(()->{
                try{
                    runnable.run();
                }finally {
                    semaphore.release();
                }
            });
        } catch (RejectedExecutionException e) {
            System.out.println("SOMETHING GET IN");
            semaphore.release();
        }


    }


}
