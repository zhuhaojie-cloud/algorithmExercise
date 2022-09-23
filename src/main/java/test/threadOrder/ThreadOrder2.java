package test.threadOrder;

import java.util.concurrent.CountDownLatch;

public class ThreadOrder2 {
    // T1、T2、T3三个线程顺序执行
    //CountDownLatch(闭锁)是一个很有用的工具类，
    // 利用它我们可以拦截一个或多个线程使其在某个条件成熟后再执行。
    // 它的内部提供了一个计数器，在构造闭锁时必须指定计数器的初始值，
    // 且计数器的初始值必须大于0。另外它还提供了一个countDown方法来操作计数器的值，
    // 每调用一次countDown方法计数器都会减1，直到计数器的值减为0时就代表条件已成熟，
    // 所有因调用await方法而阻塞的线程都会被唤醒。这就是CountDownLatch的内部机制，
    // 看起来很简单，无非就是阻塞一部分线程让其在达到某个条件之后再执行。
    public static void main(String[] args) {
        CountDownLatch c0 = new CountDownLatch(0); //计数器为0
        CountDownLatch c1 = new CountDownLatch(1); //计数器为1
        CountDownLatch c2 = new CountDownLatch(1); //计数器为1
        Thread t1 = new Thread(new Work(c0, c1));
        //c0为0，t1可以执行。t1的计数器减1
        Thread t2 = new Thread(new Work(c1, c2));
        //t1的计数器为0时，t2才能执行。t2的计数器c2减1
        Thread t3 = new Thread(new Work(c2, c2));
        //t2的计数器c2为0时，t3才能执行
        t1.start();
        t2.start();
        t3.start();
    }
//定义Work线程类，需要传入开始和结束的CountDownLatch参数
    static class Work implements Runnable {
        CountDownLatch c1;
        CountDownLatch c2;
        Work(CountDownLatch c1, CountDownLatch c2) {
            super();
            this.c1 = c1;
            this.c2 = c2;
        }
        public void run() {
            try {
                c1.await();//前一线程为0才可以执行
                System.out.println("thread start:" + Thread.currentThread().getName());
                c2.countDown();//本线程计数器减少
            } catch (InterruptedException e) {

            }
        }
    }
}
