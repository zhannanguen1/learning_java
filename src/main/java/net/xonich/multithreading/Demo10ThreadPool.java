package net.xonich.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo10ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            Future<Integer> f1 = executorService.submit(() -> {
                Thread.sleep(5000);
                return 2 * 2;
            });

            Future<Integer> f2 = executorService.submit(() -> {
                Thread.sleep(5000);
                return 3 * 3;
            });

            int r1 = f1.get();
            int r2 = f2.get();

            System.out.println(r1 + r2);
        } finally {
            executorService.shutdown();
        }

    }
}
