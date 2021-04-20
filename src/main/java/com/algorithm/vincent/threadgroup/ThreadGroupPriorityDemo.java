package com.algorithm.vincent.threadgroup;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ThreadGroupPriorityDemo {
    public static void main(String[] args) {
        // 可以为线程设置不同的优先级
//        Thread thread = new Thread();
//        System.out.println("default priority " + thread.getPriority());
//        Thread b = new Thread();
//        b.setPriority(10);
//        System.out.println("priority of b " + b.getPriority());

        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup, "thread");
        thread.setPriority(9);
        System.out.println("thread group priority " + threadGroup.getMaxPriority());
        System.out.println("thread priority " + thread.getPriority());
    }
}
