package com.algorithm.vincent.threadpermessage;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.Current;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TaskHandler implements Runnable{
    private final Request request;

    public TaskHandler(Request request) {
        this.request = request;
    }

    @Override
    public void run() {
        System.out.println("Begin handle " + request);
        slowly();
        System.out.println("End handle " + request);

    }

    private void slowly(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
