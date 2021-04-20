package com.algorithm.vincent.eventqueue;

import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class EventQueue {
    private final int max;
    private static final int DEFAULT_MAX_QUEUE_SIZE = 10;
    private LinkedList<Event> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition isEmpty = lock.newCondition();
    private Condition isFull = lock.newCondition();

    public EventQueue(){
        this(DEFAULT_MAX_QUEUE_SIZE);
    }

    public EventQueue(int max){
        this.max = max;
    }

    static class Event {

    }

    public void offer(Event event) throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() > max){
                System.out.println("queue is full");
                isFull.await();
            }
            System.out.println(event.hashCode() + " submitted");
            queue.addLast(event);
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Event take() throws InterruptedException {
        lock.lock();
        try {
            while(queue.isEmpty()){
                System.out.println("queue is empty");;
                isEmpty.await();
            }
            Event event = queue.removeFirst();
            isFull.signal();
            return event;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EventQueue queue = new EventQueue();
        new Thread(()->{
            for(;;){
                try {
                    queue.offer(new Event());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producer").start();

        new Thread(()->{
            for(;;){
                try {
                    queue.offer(new Event());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producer 2").start();

        for(int i = 0 ; i < 100; i++){
            new Thread(()->{
                for(;;){
                    try {
                        Event event = queue.take();
                    TimeUnit.MILLISECONDS.sleep(1);
                        System.out.println(event.hashCode()+ " consumed");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer " + i).start();
        }
        new Thread(()->{
            for(;;){
                try {
                    Event event = queue.take();
//                    TimeUnit.MILLISECONDS.sleep(1);
                    System.out.println(event.hashCode()+ " consumed");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "consumer1").start();

    }

}
