package lecture.livecoding;

import java.util.LinkedList;
import java.util.Queue;

class LockingQueue {

    private Queue<Integer> queue = new LinkedList<>();

    public synchronized void write(Integer value) {
        // synchronized -- only 1 thread is allowed to call the method at any time
        queue.add(value);
        // notify all threads waiting on this object's monitor
        this.notifyAll();
    }

    public synchronized Integer read() {
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return queue.poll();
    }
}


class IntProducer implements Runnable {
    int limit;
    LockingQueue lockingQueue;

    public IntProducer(LockingQueue lockingQueue, int limit) {
        // how many number to add to the queue in total
        this.limit = limit;
        this.lockingQueue = lockingQueue;

    }

    @Override
    public void run() {
        int currentValue = 0;
        while (currentValue <= limit) {
            // Java boxing => int -> Integer
            lockingQueue.write(currentValue);
            System.out.println(Thread.currentThread().getName() + " added -> " + currentValue);
            currentValue += 1;
        }
        lockingQueue.write(-1);
        lockingQueue.write(-1);
        System.out.println(Thread.currentThread().getName() + " added -1's ");
    }
}

class IntConsumer implements Runnable {
    LockingQueue lockingQueue;

    public IntConsumer(LockingQueue lockingQueue) {
        this.lockingQueue = lockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            Integer value = lockingQueue.read();

            if (value == -1) {
                break;
            } else {
                System.out.println(Thread.currentThread().getName() + " read value -> " + value);
            }
        }
    }
}


public class Lecture_12 {
    public static void main(String[] args) {
        LockingQueue lockingQueue = new LockingQueue();

        Thread producer_1 = new Thread(new IntProducer(lockingQueue, 20));
        Thread consumer_1 = new Thread(new IntConsumer(lockingQueue));
//        consumer_1.setDaemon(true);
        Thread consumer_2 = new Thread(new IntConsumer(lockingQueue));
//        consumer_2.setDaemon(true);

        producer_1.start();

        consumer_1.start();
        consumer_2.start();
    }

}
