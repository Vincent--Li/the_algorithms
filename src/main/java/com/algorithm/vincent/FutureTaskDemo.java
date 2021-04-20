package com.algorithm.vincent;

import java.util.concurrent.*;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class FutureTaskDemo {
    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        FutureTaskDemo futureTaskDemo = new FutureTaskDemo();
        String result = futureTaskDemo.executionTask("TEST");
        String result2 = futureTaskDemo.executionTask("TEST");
        String result3 = futureTaskDemo.executionTask("TEST2");
        System.out.printf("%s, %s, %s", result, result2, result3);

    }

    private String executionTask(final String taskName){
        while(true){
            Future<String> future = taskCache.get(taskName);
            if(future == null){
                Callable<String> task = new Callable<String>(){
                    @Override
                    public String call() throws Exception {
                        System.out.println("Task executed, " + taskName);
                        return taskName;
                    }
                };
                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName, futureTask);
                if(future == null){
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                taskCache.remove(taskName, future);
            } catch (ExecutionException e) {
                e.printStackTrace();
                taskCache.remove(taskName, future);
            }
        }
    }
}
