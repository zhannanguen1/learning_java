package net.xonich.multithreading;

public class MyConcurrentQueue<T> {

    private final Object[] data; // массив для хранения элементов очереди
    private int start; // начало
    private int size; //текущее кол-во элементов в очереди

    public MyConcurrentQueue(int capacity) {
        data = new Object[capacity];
    } // создаем массив

    public synchronized void offer(T val) throws InterruptedException {

        // ждем, когда в очереди появится место
            while (size == data.length) {
                wait();
            }
            // добавляем элемент в конец очереди
            data[(start + size) % data.length] = val;
            size++;
            notifyAll();

    }

    public T poll() throws InterruptedException {

        synchronized (this) {

            // ждем, пока в очереди не появится хотя бы один элемент
            while (size == 0) {
                wait();
            }

            // извлекаем элемент из начала очереди
            T datum = (T) data[start];
            data[start] = null; // очищаем ячейку

            // Обновляем индекс начала очереди
            if (start == data.length - 1) { //start = (start + 1) % data.length
                start = 0;
            } else {
                start++;
            }
            size--;
            notifyAll();
            return datum;

        }
    }
}
