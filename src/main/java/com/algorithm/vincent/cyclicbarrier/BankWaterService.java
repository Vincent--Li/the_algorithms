package com.algorithm.vincent.cyclicbarrier;

import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class BankWaterService implements Runnable {

    private CyclicBarrier c = new CyclicBarrier(4, this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count(){
        for(int i = 0; i < 4; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        LongAdder result = new LongAdder();
        sheetBankWaterCount.forEach((key, value)->{
            result.add(value);
        });
        System.out.println(result.longValue());
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
