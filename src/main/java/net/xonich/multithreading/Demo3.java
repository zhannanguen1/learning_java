package net.xonich.multithreading;

import java.math.BigDecimal;

public class Demo3 {

    public static class Task implements Runnable {

        int begin;
        int end;
        BigDecimal result = BigDecimal.ONE;
        long executionTime;

        public Task(int begin, int end) {

            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            long startTime = System.nanoTime();
            for (int i = begin; i <= end; i++) {
                result = result.multiply(BigDecimal.valueOf(i));
            }
            executionTime = System.nanoTime() - startTime;
        }

        public BigDecimal result() {
            return result;
        }

        public long getExecutionTime() {
            return executionTime;
        }
    }

    public static int step(int number, int numThreads) {

        return number / numThreads;
    }

    public static void main(String[] args) throws InterruptedException {

        int factorialNumber = 101;
        int numThreads = 4;
        int step = step(factorialNumber, numThreads);
        int begin = 1;
        int end = step;

        Thread[] threads = new Thread[numThreads];
        Task[] tasks = new Task[numThreads];

        for (int i = 0; i < numThreads; i++) {

            if (i == numThreads - 1) {
                end = factorialNumber;
            }

            tasks[i] = new Task(begin, end);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
            begin = end + 1;
            end = end + step;
        }

        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
            result = result.multiply(tasks[i].result());
            System.out.println(tasks[i].getExecutionTime() + " - thread " + i);
        }
        System.out.println(result);
    }
}
