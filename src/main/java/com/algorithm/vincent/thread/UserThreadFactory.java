package com.algorithm.vincent.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String featureName){
        this.namePrefix = "From UserThreadFactory " + featureName + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
//        System.out.println(thread.getName());

        return thread;
    }
}
