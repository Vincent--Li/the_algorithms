package com.algorithm.vincent.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<List<Integer>> exchanger = new Exchanger<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Producer((exchanger)));
        executor.execute(new Producer((exchanger)));
    }
}

class Producer extends Thread {
    List<Integer> list = new ArrayList<>();
    Exchanger<List<Integer>> exchanger = null;

    public Producer(Exchanger<List<Integer>> exchanger){
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        Random random = new Random();
        int num;
        num = random.nextInt(10000);
        list.add(num);
        num = random.nextInt(10000);
        list.add(num);
        num = random.nextInt(10000);
        list.add(num);
        num = random.nextInt(10000);
        list.add(num);
        try {
            System.out.print(Thread.currentThread().getName() + ": 交换前:");
            print();
            list = exchanger.exchange(list);
            System.out.println(Thread.currentThread().getName() + ": 交换后:");
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void print(){
        System.out.println(list);
    }
}
