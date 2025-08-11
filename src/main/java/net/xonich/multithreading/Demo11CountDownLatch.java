package net.xonich.multithreading;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo11CountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(4);
        CountDownLatch referee = new CountDownLatch(1);
        CountDownLatch runners = new CountDownLatch(4);

        try {
            System.out.println("Ждем бегунов : " + LocalTime.now());
            for (int i = 0; i < 4; i++) {
                int x = i;
                System.out.println("Создается задача для " + x);
                es.submit(() -> {
                    Random r = new Random();
                    int remaining = 1000;

                    System.out.println("Бегун № " + x + " пришел в " + LocalTime.now() + " и ожидает старта");
                    runners.countDown();
                    System.out.println("Судья ожидает всех бегунов в " + x + " " + LocalTime.now());
                    referee.await();
                    System.out.println("Судья дает сигнал " + x + " "  + LocalTime.now());
                    System.out.println("Бегун № " + x + " стартовал в " + LocalTime.now());
                    while (remaining > 0) { // Цикл бега, пока не будет пройдена вся дистанция
                        Thread.sleep(10);
                        remaining -= r.nextInt(5); // Уменьшение оставшейся дистанции на случайное значение (0-4)
                    }
                    System.out.println("Бегун # " + x + " финишировал в " + LocalTime.now());
                    return true;
                });
            }
            runners.await();
            System.out.println("Судья готовится дать сигнал  " + LocalTime.now());
            referee.countDown();
        } finally {
            es.shutdown();
        }
    }
}
