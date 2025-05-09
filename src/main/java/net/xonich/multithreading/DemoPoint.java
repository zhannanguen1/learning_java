package net.xonich.multithreading;

import java.util.Arrays;

public class DemoPoint {

    static class Task implements Runnable {
        private final Point point;
        private final double dx;
        private final double dy;

        public Task(Point point, double dx, double dy) {
            this.point = point;
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                point.translate(dx, dy);
            }
            System.out.println(Thread.currentThread().getName() +
                    " переместил на (" + dx + ", " + dy + ")");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Point point = new Point(0, 0);

        Task task1 = new Task(point, 1, 2);
        Task task2 = new Task(point, 3, -4.1);
        Task task3 = new Task(point, -2, 3.5);
        Task task4 = new Task(point, 0.5, 0.5);
        Task task5 = new Task(point, -1, -1.5);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        Thread t4 = new Thread(task4);
        Thread t5 = new Thread(task5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Сейчас точка в позиции: " + point.getX() + ", " + point.getY());
    }
}
