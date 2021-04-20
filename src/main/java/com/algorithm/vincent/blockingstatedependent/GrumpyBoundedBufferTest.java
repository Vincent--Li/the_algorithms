package com.algorithm.vincent.blockingstatedependent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.FutureTask;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class GrumpyBoundedBufferTest {
    public static void main(String[] args) {
        GrumpyBoundedBuffer<Object> buffer = new GrumpyBoundedBuffer(5);

        FutureTask ft1 = new FutureTask(()->{
           while(true){
               try {
                   Object item = buffer.take();
                   return item;
               } catch (BufferEmptyException e) {
                   e.printStackTrace();
               }
           }
        });

        FutureTask ft2 = new FutureTask(()->{
           while(true){
               try {
                   buffer.put(new Object());
               } catch (BufferFullException e) {
                   e.printStackTrace();
               }
           }
        });
    }
}
