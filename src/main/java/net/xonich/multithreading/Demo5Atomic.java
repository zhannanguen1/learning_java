package net.xonich.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo5Atomic {

    private static final int END = 100;
    AtomicInteger curr = new AtomicInteger(1);

    public class Task implements Runnable {

        @Override
        public void run() {

            while (true) {

               if (curr.get() % 3 == 0 && curr.get() % 5 != 0) {

                   System.out.println("Fizz");
                   curr.getAndIncrement();
               }
            }
        }
    }
}
