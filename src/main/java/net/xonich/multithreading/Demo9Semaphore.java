package net.xonich.multithreading;

import java.util.concurrent.Semaphore;

public class Demo9Semaphore {

    public static void main(String[] args) throws InterruptedException {

        Semaphore sm = new Semaphore(10);

        sm.acquire(3);
        sm.release();
    }
}
