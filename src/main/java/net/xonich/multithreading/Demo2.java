package net.xonich.multithreading;

public class Demo2 {

    public static class Task implements Runnable {

        int begin;
        int end;
        int sum = 0;

        public Task(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " : " + System.nanoTime());
            for (int i = begin; i <= end; i++) {

                sum = sum + i;
            }
            System.out.println(Thread.currentThread().getName() + " : " + sum);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Task task1 = new Task(1, 500_000);
        Thread t1 = new Thread(task1);
        Task task2 = new Task(500_001, 1_000_000);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("task1.sum + task2.sum = " + (task1.sum + task2.sum));
        System.out.println(task1.sum + task2.sum + "");
    }
}
