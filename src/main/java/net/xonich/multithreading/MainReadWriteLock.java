package net.xonich.multithreading;

public class MainReadWriteLock {

    public static void main(String[] args) {

        int size = 10;
        ReadWriteLockArray<Integer> array = new ReadWriteLockArray<>(size);
        int writers = 3;
        int readers = 5;

        for (int i = 0; i < writers; i++) {

            new Thread(() -> {

                for (int j = 0; j < size; j++) {
                    int idx = (int) (Math.random() * size);
                    int element = (int) (Math.random() * 10000);
                    array.set(idx, element);
                    System.out.println("Writer " + Thread.currentThread().getName() + " wrote " + element + " to index " + idx);
                }
            }).start();
        }

        for (int i = 0; i < readers; i++) {

            new Thread(() -> {

                for (int j = 0; j < size; j++) {
                    int idx = (int) (Math.random() * size);
                    Integer element = array.get(idx);
                    System.out.println("Reader " + Thread.currentThread().getName() + " read " + element + " from index " + idx);
                }
            }).start();
        }

        new Thread(() -> {
            for (int i = 0; i < readers; i++) {
                System.out.println("Array: " + array);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
