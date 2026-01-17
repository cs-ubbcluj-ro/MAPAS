package lecture.examples.lecture13;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
//                lock.lock();              // acquire lock
//                try {
                    counter++;
//                } finally {
//                    lock.unlock();        // always release lock
//                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Counter = " + counter);
    }
}

