package com.algorithm.vincent.timedwaiting;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TimedWating {
    private static Object result;

    // 常用范式等待超时,返回
    public synchronized Object get(long millis) throws InterruptedException {
        final long future = System.currentTimeMillis() + millis;
        long remaining = millis;
        while (result == null && remaining > 0) {
            //DO something for result
            wait(millis);
            remaining = future - System.currentTimeMillis();
        }
        return result;
    }
}
