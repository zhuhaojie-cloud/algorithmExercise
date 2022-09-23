package test.threadOrder;

public class ThreadOrder {
    // T1、T2、T3三个线程顺序执行
    //thread.Join把指定的线程加入到当前线程，
    // 可以将两个交替执行的线程合并为顺序执行的线程。
    // 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B
    public static void main(String[] args) {
        Thread t1 = new Thread(new Work(null));
        Thread t2 = new Thread(new Work(t1));
        Thread t3 = new Thread(new Work(t2));
        t1.start();
        t2.start();
        t3.start();
    }
    static class Work implements Runnable {
        private Thread beforeThread;
        public Work(Thread beforeThread) {
            this.beforeThread = beforeThread;
        }
        public void run() {
            if (beforeThread != null) {
                try {
                    beforeThread.join();
                    System.out.println("thread start:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("thread start:" + Thread.currentThread().getName());
            }
        }
    }
}
