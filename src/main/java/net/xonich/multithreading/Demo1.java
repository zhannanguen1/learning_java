package net.xonich.multithreading;

public class Demo1 {

    public static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from another thread");
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Task());
        t1.start();

        Thread.sleep((long) (Math.random() * 1000));
        System.out.println("Hello, World");
    }
}
