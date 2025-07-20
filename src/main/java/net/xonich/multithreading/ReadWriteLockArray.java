package net.xonich.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockArray<T> {

    private final T[] array;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock rLock = lock.readLock();
    private final Lock wLock = lock.writeLock();

    @SuppressWarnings("unchecked")
    ReadWriteLockArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public T get(int idx) {

        rLock.lock();
        try {
            if (idx < 0 || idx >= array.length) {
                throw new IndexOutOfBoundsException("");
            }
            return array[idx];
        } finally {
            rLock.unlock();
        }
    }

    public void set(int idx, T element) {

        wLock.lock();
        try {
            if (idx < 0 || idx >= array.length) {
                throw new IndexOutOfBoundsException();
            }
            array[idx] = element;
        } finally {
            wLock.unlock();
        }
    }

    public int length() {
//        rLock.lock(); Не нужен лок
        try {
            return array.length;
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public String toString() {
        rLock.lock();
        try {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i < array.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        } finally {
            rLock.unlock();
        }
    }
}
