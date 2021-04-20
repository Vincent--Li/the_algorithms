package com.algorithm.vincent.cancellation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class UnbreakableTask {

    public UnbreakableTask getNextTask(BlockingQueue<UnbreakableTask> queue){
        boolean interrupted = false;
//        try {
            while (true) {
                try {
                    // 这个地方会响应中断, 但是不能取消执行的话. 就通过loop的方式执行. 但是要保留中断状态
                    return queue.take();
                } catch (InterruptedException e) {
                    System.out.println("interrupt captured");
                    interrupted = true;
                }
            }
//        } finally {
//            if(interrupted){
//                System.out.println("PASS");
//                Thread.currentThread().interrupt();
//            }
//        }
    }

    public static void main(String[] args) {
        BlockingQueue<UnbreakableTask> queue = new ArrayBlockingQueue<>(1);
        UnbreakableTask unbreakableTask = new UnbreakableTask();

        Thread thread = new Thread(()->{
            unbreakableTask.getNextTask(queue);
        });
        thread.start();
        thread.interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            queue.put(new UnbreakableTask());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
