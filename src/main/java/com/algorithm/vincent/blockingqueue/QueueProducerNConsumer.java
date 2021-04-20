package com.algorithm.vincent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class QueueProducerNConsumer {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        QueueProducerNConsumer task = new QueueProducerNConsumer();
        Producer producer = task.new Producer();
        Consumer consumer = task.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume(){
            while(true){
                try {
                    queue.take();
                    System.out.println("take an element form queue, left: " + queue.size());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce(){
            while(true){
                try {
                    queue.put(1);
                    System.out.println("put an element to queue, left: " + queue.size());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
