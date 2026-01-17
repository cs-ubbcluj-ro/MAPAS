package lecture.examples.lecture12;

import lecture.examples.lecture12.Prime;

public class Main {
    public static void main(String[] args) {

        // get current thread information
        Thread currentThread = Thread.currentThread();
        System.out.println("Main thread name : " + currentThread.getName());

        Thread fibThread = new Thread(new Fibonacci(30), "Fibonacci");
        // NB! When all running threads are daemon threads, the JVM will shut down
        // fibThread.setDaemon(true);


        fibThread.start(); // call the method start(), not run() (to make sure a new thread is created)!
        System.out.println("Thread " + fibThread.getName() + " has started.");

        Thread primeThread = new Thread(new Prime(20), "Primes");
        // primeThread.setDaemon(true);

        primeThread.start();
        System.out.println("Thread " + primeThread.getName() + " has started.");

        // the current thread continues its execution,
        // without waiting for the other threads
        System.out.println("Main thread keeps running.");
    }
}
