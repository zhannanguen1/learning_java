package net.xonich.collections;

import java.util.Arrays;

public class MyArrayList {

    private int size = 0;
    private int[] store = new int[10];

    public int get(int idx) {
        ensureIndex(idx);
        return store[idx];
    }

    private void ensureIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Индекс " + idx + " выходит за пределы диапазона " + "0 .. " + size);
        }
    }

    public void set(int idx, int val) {
        ensureIndex(idx);
        store[idx] = val;
    }

    public void add(int val) {

        if (size >= store.length) {

            int[] newStore = new int[store.length * 2];
            for (int i = 0; i < store.length; i++) {

                newStore[i] = store[i];
            }
//            System.arraycopy(store, 0, newStore, 0, store.length); аналогичный код
            store = newStore;
        }
        store[size] = val;
        size++;
    }

    public void remove(int idx) { //toDo

        ensureIndex(idx);

        store[idx] = 0;

        for (int i = idx; i < size - 1; i++) {
            store[i] = store[i + 1];
        }
        size--;
    }

    public int size() {

        return size;
    }

    @Override
    public String toString() { //toDo сделать распечатку Arrays.toString
        return Arrays.toString(store);
    }
}
