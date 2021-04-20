package com.algorithm.vincent.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        boolean isLocked = reentrantLock.tryLock();
        if(isLocked){
            try{
                System.out.println("I like you");
                Integer tmp = 1/0;
            }finally {
                System.out.println("unlock");
                reentrantLock.unlock();
            }
        }
    }
}
