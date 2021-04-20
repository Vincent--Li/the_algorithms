package com.algorithm.vincent.memoization;

import java.math.BigInteger;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }

    @Override
    public int getCacheSize() {
        return 0;
    }


}
