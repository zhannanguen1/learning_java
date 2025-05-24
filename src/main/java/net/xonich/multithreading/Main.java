package net.xonich.multithreading;

public class Main {

    public static class Acceptor implements Runnable {
        private long sum;
        private int max = 0;
        private int min = Integer.MAX_VALUE;
        private final Object mutex = new Object();


        public void accept(int number) {

            synchronized (mutex) {
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
                sum += number;
            }
        }

        public long getSum() {

                return sum;
        }

        public int getMin() {

            return min;
        }

        public int getMax() {

            return max;
        }

        @Override
        public void run() {

            try {
                long sleepTime = (long) (Math.random() * 200);
                Thread.sleep(sleepTime);

                int number = (int) (Math.random() * 1_000_000);
                accept(number);

                System.out.println(Thread.currentThread().getName() + " : " + number);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[4];
        Acceptor acceptor = new Acceptor();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(acceptor);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("acceptor.getSum() = " + acceptor.getSum());
        System.out.println("acceptor.getMax() = " + acceptor.getMax());
        System.out.println("acceptor.getMin() = " + acceptor.getMin());
    }
}
