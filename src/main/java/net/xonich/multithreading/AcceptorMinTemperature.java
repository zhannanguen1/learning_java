package net.xonich.multithreading;

import java.util.concurrent.atomic.DoubleAccumulator;

public class AcceptorMinTemperature {

    public static class Acceptor implements Runnable {

        // Double::min возвращает меньшее из двух чисел
        // Double.POSITIVE_INFINITY - начальное значение, представляющее "бесконечность" (первое же реальное значение температуры заменит начальное значение)
        private final DoubleAccumulator minTemperatureAccumulator = new DoubleAccumulator(Double::min, Double.POSITIVE_INFINITY);

        public double getMin() {

            return minTemperatureAccumulator.get();
        }

        @Override
        public void run() {

            double temperature = Math.round(Math.random() * 100 - 50) * 10 / 10.0;
            minTemperatureAccumulator.accumulate(temperature);

            System.out.println(Thread.currentThread().getName() + ": " + temperature + " °C");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[(int) (Math.random() * 10)];
        Acceptor acceptor = new Acceptor();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(acceptor, "Thread-" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("acceptor.getMin() = " + acceptor.getMin() + " °C");
    }
}
