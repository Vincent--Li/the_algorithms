package com.algorithm.vincent.boundedqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class BoundedQueue<T> {
    private Object[] items;
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size){
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try{
            while(count == items.length){
                notFull.await();
            }
            items[addIndex] = t;
            if(++addIndex == items.length){
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }


}
