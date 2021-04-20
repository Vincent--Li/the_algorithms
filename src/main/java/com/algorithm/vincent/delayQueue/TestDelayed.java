package com.algorithm.vincent.delayQueue;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author by zhiyuan.li@hand-china.com
 */
@Slf4j
public class TestDelayed {

    @Test
    public void testDelayQueue() throws InterruptedException {
        DelayQueue<DelayedImpl> delayQueue = new DelayQueue<>();
        delayQueue.offer(new DelayedImpl("aaa", 5, TimeUnit.SECONDS));
        delayQueue.offer(new DelayedImpl("bbb", 1, TimeUnit.SECONDS));
        delayQueue.offer(new DelayedImpl("ccc", 3, TimeUnit.SECONDS));
        List<String> tests = new ArrayList<>();
        tests.add("A");
        tests.add("A");
        tests.add("A");

        log.info("Test Started");
        log.info(delayQueue.take().getStr());
        log.info(delayQueue.take().getStr());
        log.info(delayQueue.take().getStr());
        log.info("Test Ended");
        log.info("test {}", tests);

        Collections.sort(tests, Collections.reverseOrder());
    }
}
