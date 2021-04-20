package threadcommunication;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class JoinDemo {
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("This is the child thread go to sleep");
                Thread.sleep(1000);
                System.out.println("This is the child thread wake up ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
//        thread.join();
        System.out.println("join makes great difference");
    }
}
