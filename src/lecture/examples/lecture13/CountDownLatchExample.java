package lecture.examples.lecture13;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println("Worker " + id + " started");
                try {
                    Thread.sleep(1000 * id); // simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Worker " + id + " finished");
                latch.countDown(); // signal completion
            }).start();
        }

        System.out.println("Main thread waiting...");
        latch.await(); // wait until counter reaches zero
        System.out.println("All workers finished. Main thread continues.");
    }
}

