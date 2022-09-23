package test.threadOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadOrder1 {
    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread1");
        }
    });

    static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread2");
        }
    });

    static Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread3");
        }
    });
    // 利用只有一个线程的线程池，按顺序执行thread1 -> thread2 -> thread3
    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws InterruptedException {
        executorService.submit(thread1); // 1、执行thread1
        executorService.submit(thread2); // 2、执行thread2
        executorService.submit(thread3); // 3、执行thread3
        executorService.shutdown();
    }
}
