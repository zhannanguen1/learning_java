package net.xonich.multithreading;

public class Demo5 {

    private static final int END = 100;
    private static int curr = 1;
    private static final Object mutex = new Object();

    public static class NumberTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (mutex) {
                    if (curr > END) {
                        return;
                    }
                    if (curr % 3 != 0 && curr % 5 != 0) {
                        System.out.print(Thread.currentThread().getName() + ": ");
                        System.out.println(curr);
                        curr++;
                        mutex.notifyAll();
                    } else {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public static class FizzTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (mutex) {
                    if (curr > END) {
                        return;
                    }
                    if (curr % 3 == 0 && curr % 5 != 0) {
                        System.out.print(Thread.currentThread().getName() + ": ");
                        System.out.println("Fizz");
                        curr++;
                        mutex.notifyAll();
                    } else {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public static class BuzzTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (mutex) {
                    if (curr > END) {
                        return;
                    }
                    if (curr % 3 != 0 && curr % 5 == 0) {
                        System.out.print(Thread.currentThread().getName() + ": ");
                        System.out.println("Buzz");
                        curr++;
                        mutex.notifyAll();
                    } else {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public static class FizzBuzzTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (mutex) {
                    if (curr > END) {
                        return;
                    }
                    if (curr % 15 == 0) {
                        System.out.print(Thread.currentThread().getName() + ": ");
                        System.out.println("FizzBuzz");
                        curr++;
                        mutex.notifyAll();
                    } else {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Thread fizzThread = new Thread(new FizzTask());
        Thread buzzThread = new Thread(new BuzzTask());
        Thread fizzBuzzThread = new Thread(new FizzBuzzTask());
        Thread numberThread = new Thread(new NumberTask());

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        fizzThread.join();
        buzzThread.join();
        fizzBuzzThread.join();
        numberThread.join();
    }
}
