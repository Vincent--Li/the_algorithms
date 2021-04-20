package com.algorithm.vincent.reordering;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ReorderingDemo {
    private static int x=0, y=0, a = 0, b = 0;
    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for(;;){
            i ++;
            x=0; y=0;
            a=0; b=0;
            Thread thread1 = new Thread(new Runnable(){
                @Override
                public void run() {
                    synchronized (lock){
                        try {
                            Thread.sleep(10);
                            a = 1;
                            x = b;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable(){
                @Override
                public void run() {
                    synchronized (lock){
                        try {
                            Thread.sleep(10);
                            b = 1;
                            y = a;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println("No: " + i + ": (x,y) is : (" + x + "," + y + ")");
            if(x == 0 && y ==0 ){
                System.out.println("跑出来了 No: " + i);
                break;
            }
        }
    }
}
