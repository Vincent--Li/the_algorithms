package com.algorithm.vincent.cancellation;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class PrimeGeneratorTest {
    public static void main(String[] args) {
        PrimeGenerator p = new PrimeGenerator();
        new Thread(p).start();
//        new Thread(p).start();
//        new Thread(p).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            p.cancel();
        }
        System.out.println(p.get().size());
    }
}
