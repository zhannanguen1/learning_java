package net.xonich.multithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo12CyclicBarrier {

    public static void main(String[] args) {

        final int RUNNERS_COUNT = 4;
        final int LAPS_COUNT = 3;

        ExecutorService es = Executors.newFixedThreadPool(RUNNERS_COUNT);
        CyclicBarrier barrier = new CyclicBarrier(RUNNERS_COUNT);
        CountDownLatch startSignal = new CountDownLatch(1);

        try {
            for (int i = 0; i < RUNNERS_COUNT; i++) {
                int x = i;
                es.submit(() -> {
                    Random r = new Random();
                    int remaining = 1000;

                    System.out.println("Бегун № " + x + " ожидает старта");
                    startSignal.await();
                    System.out.println("Бегун № " + x + " стартовал");

//                    for (int j = 0; j < LAPS_COUNT; j++) { // кол-во кругов = 3
//
//                        while (remaining > 0) {
//                            Thread.sleep(10);
//                            remaining -= r.nextInt(5);
//                        }
//                        System.out.println("Бегун № " + x + " завершил круг " + j);
//
//
//                            barrier.await();
//                    }

                    while (remaining > 0) {
                        barrier.await();
                        System.out.println("Бегун № " + x + " делает шаг");
                        remaining -= r.nextInt(5);
                    }

                    System.out.println("Бегун № " + x + " финишировал!");
                    return true;
                });
            }
            System.out.println("Судья готовится дать сигнал старта");
            Thread.sleep(1000);
            startSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }
}
