package net.xonich.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo6 {
    private static final AtomicInteger produced = new AtomicInteger(0);
    private static final AtomicInteger consumed = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        MyConcurrentQueue<Integer> queue = new MyConcurrentQueue<>(10);

        runTest(queue, 10, 2);

        produced.set(0);
        consumed.set(0);

        runTest(queue, 2, 10);
    }

    private static void runTest(MyConcurrentQueue<Integer> queue, int producerCount, int consumerCount) throws InterruptedException {

        Thread[] producers = new Thread[producerCount];
        Thread[] consumers = new Thread[consumerCount];

        for (int i = 0; i < producerCount; i++) {
            producers[i] = new Thread(() -> {
                try {
                    while (produced.getAndIncrement() < 10) {
                        int value = (int) (Math.random() * 100);
                        queue.offer(value);
                        System.out.println("Produced: " + value);
                    }
                    produced.decrementAndGet(); //Если условие цикла не выполнилось, уменьшаем счетчик (так как getAndIncrement уже увеличил его)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            producers[i].start();
        }

        // Создаем и запускаем потребителей
        for (int i = 0; i < consumerCount; i++) {
            consumers[i] = new Thread(() -> {
                try {
                    while (consumed.getAndIncrement() < 10) {
                        Integer value = queue.poll();
                        System.out.println("Consumed: " + value);
                    }
                    consumed.decrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            consumers[i].start();
        }

        // Ожидаем завершения всех производителей
        for (Thread producer : producers) {
            producer.join();
        }

        // Ожидаем завершения всех потребителей
        for (Thread consumer : consumers) {
            consumer.join();
        }

        System.out.println("Произведено элементов: " + produced.get());
        System.out.println("Потреблено элементов: " + consumed.get());
        System.out.println("Размер очереди: " + queue.size);
    }
}
