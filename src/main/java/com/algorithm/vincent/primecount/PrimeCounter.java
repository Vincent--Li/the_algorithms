package com.algorithm.vincent.primecount;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class PrimeCounter {
    public static void main(String[] args) {
        for(int i = 100; i < 10000; i+=100){
            System.out.println("(" + i + "," + count(i) + ")");
        }

    }

    public static int count(int n){
        int count = 0;
        //false = 质数
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++ ){
            if(!isPrime[i]){
                count++;
                for(int j = i * i; j < n; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
