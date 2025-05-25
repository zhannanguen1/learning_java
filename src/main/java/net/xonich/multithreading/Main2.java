package net.xonich.multithreading;

import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.LongAdder;

public class Main2 {

    public static int THREAD_COUNT = 4;
    private static final int CYCLES = 20_000_000;

    public static class Acceptor implements Runnable {

        private long[] sum = new long[THREAD_COUNT];
        private int[] max = new int[THREAD_COUNT];
        private int[] min = new int[THREAD_COUNT];
        private final Object mutex = new Object();

        private AtomicIntegerArray ia = new AtomicIntegerArray(THREAD_COUNT);



        public void accept(int number) {
            int tId = Integer.parseInt(Thread.currentThread().getName());

            if (number > max[tId]) {
                max[tId] =  number;
            }
//            if (number < min[tId]) {
//                min.ptId,number);
//            }
            sum[tId] += number;
        }

        public long getSum() {
            synchronized (mutex) {
                long res = 0;
                for (long l : sum) {
                    res += l;
                }

                return res;
            }
        }


        public int getMin() {

            return 0;
        }

        public int getMax() {
            synchronized (mutex){
                int res = Integer.MIN_VALUE;
                for (int i : max) {
                    if (i > res)
                        res = i;
                }
                return res;
            }
        }

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < CYCLES; i++) {
                try {
//                    long sleepTime = (long) (Math.random() * 200);
//                    Thread.sleep(sleepTime);

                    int number = random.nextInt(1_000_000);
                    accept(number);

//                    System.out.println(Thread.currentThread().getName() + " : " + number);

//                    if (i % 1000 == 0)
//                        System.out.println("iteration " + i);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static class AcceptorAtomic {
        private final LongAdder adder = new LongAdder();

        public void accept(int num){
            adder.add(num);
        }

        public long getSum(){
            return adder.sum();
        }
    }


    public static class Task implements Runnable {
        private final AcceptorAtomic acceptor;

        public Task(AcceptorAtomic acceptor) {
            this.acceptor = acceptor;
        }

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < CYCLES; i++) {
                acceptor.accept(random.nextInt(1_000_000));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
/*
        Thread[] threads = new Thread[4];
        Acceptor acceptor = new Acceptor();


        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(acceptor, "" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }


        System.out.println("acceptor.getSum() = " + acceptor.getSum());
        System.out.println("acceptor.getMax() = " + acceptor.getMax());
        System.out.println("acceptor.getMin() = " + acceptor.getMin());*/

        Thread[] threads = new Thread[THREAD_COUNT];
        AcceptorAtomic acceptor = new AcceptorAtomic();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Task(acceptor));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        long finish = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (finish - start) + "ms");

        System.out.println("acceptor.getSum() = " + acceptor.getSum());
    }
}
