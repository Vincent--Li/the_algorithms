package com.algorithm.vincent.cache;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class Reference {

    private final byte[] data = new byte[2<<19];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("the reference will be GC. ");
    }
}
