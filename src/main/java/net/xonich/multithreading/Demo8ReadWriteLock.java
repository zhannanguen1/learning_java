package net.xonich.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo8ReadWriteLock {

    private static int LOOP_SIZE = 100_000;

    public static class DataHolder {

        private int a;
    }

    public static void main(String[] args) throws InterruptedException {

        DataHolder dh = new DataHolder();

        List<Thread> readers = new ArrayList<>();

        ReadWriteLock rwLock = new ReentrantReadWriteLock();

        Lock rLock = rwLock.readLock();
        Lock wLock = rwLock.writeLock();

        for (int i = 0; i < 8; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < LOOP_SIZE; j++) {
                    rLock.lock();

                    int x;
                    try {
                        x = dh.a;
                    } finally {
                        rLock.unlock();
                    }

                    if (j % 1000 == 0) {
                        System.out.println("Thread: " + Thread.currentThread().getName() + " dh.a = " + x);
                    }
                }
            });
            readers.add(t);
        }

        Thread writer = new Thread(() -> {
            for (int j = 0; j < LOOP_SIZE; j++) {
                wLock.lock();

                try {
                    dh.a += 42;
                } finally {
                    wLock.unlock();
                }
            }
        });

        readers.forEach(t -> t.start());
        writer.start();

        for (Thread thread : readers) {
            thread.join();
        }
        writer.join();
    }
}
