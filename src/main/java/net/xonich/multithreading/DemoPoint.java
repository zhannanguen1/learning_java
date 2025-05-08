package net.xonich.multithreading;

public class DemoPoint {

    public static void main(String[] args) throws InterruptedException {

        final Point point = new Point(0, 0);
        final int threadCount = 10;
        final int operationsPerThread = 100;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < operationsPerThread; j++) {
                    point.translate(1.5, -2);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(point);
    }
}
