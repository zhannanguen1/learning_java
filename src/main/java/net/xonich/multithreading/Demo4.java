package net.xonich.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo4 {

    static int counter = 0;
    static AtomicInteger atomicCounter = new AtomicInteger(0);

    static final Object mutex = new Object();
    public static class SynchronizedTask implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 1_000_000; i++) {
                synchronized (mutex) {
                    counter++;
                }
            }
        }
    }

    public static class AtomicTask implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 1_000_000; i++) {
                atomicCounter.getAndIncrement();
            }
        }
    }

    public static void mainSynch(String[] args) throws InterruptedException {

        Thread thread = new Thread(new SynchronizedTask());
        Thread thread1 = new Thread(new SynchronizedTask());

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(counter);
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new AtomicTask());
        Thread thread1 = new Thread(new AtomicTask());

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(atomicCounter.get());
    }
}
