package com.algorithm.vincent.future;

import javax.swing.text.html.FormSubmitEvent;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class FutureServiceTest {
    public static void main(String[] args) throws InterruptedException {
        FutureService<Integer, String> futureService = FutureService.newService();
        Task<Integer, String > task = new Task<Integer, String>() {
            @Override
            public String get(Integer input) {
                try {
                    TimeUnit.SECONDS.sleep(input);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "sleep for " + input;
            }
        };
        Future<String> future5 = futureService.submit(task, 5, System.out::println);
//        System.out.println(future5.get());

    }
}
