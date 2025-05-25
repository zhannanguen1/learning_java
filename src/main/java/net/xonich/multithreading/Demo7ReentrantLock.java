package net.xonich.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Demo7ReentrantLock {

    public static class DataHolder {

        private int a;
    }

    public static void main(String[] args) throws InterruptedException {

        DataHolder dh = new DataHolder();

        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                lock.lock();
                try {
                    dh.a++;
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                lock.lock();
                dh.a++;
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(dh.a);
    }
}
