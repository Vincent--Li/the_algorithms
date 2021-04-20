package threadcommunication;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class Signal {
    private static volatile int signal = 0;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while(signal < 1000){
                if(signal % 3 == 0){
                    System.out.println("ThreadA: " + signal);
                    synchronized (this){
                        signal++;
                    }
                }
            }
        }
    }
    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while(signal < 1000){
                if(signal % 3 == 1){
                    System.out.println("ThreadB: " + signal);
                    synchronized (this){
                        signal++;
                    }
                }
            }
        }
    }

    static class ThreadC implements Runnable {
        @Override
        public void run() {
            while(signal < 1000){
                if(signal % 3 == 2){
                    System.out.println("ThreadC: " + signal);
                    synchronized (this){
                        signal++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
//        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();
    }
}
