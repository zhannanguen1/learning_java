package net.xonich.collections;

import java.util.Arrays;

public class MyArrayList {

    private int size = 0;
    private int[] store = new int[10];

    public int get(int idx) {

        return store[idx];
    }

    public void set(int idx, int val) {

        if (idx < 0 || idx >= store.length) {
            throw new BusinessExceptions("Индекс выходит за пределы массива");
        }

        if (idx > size - 1) {
            store[size] = val;
            size++;
        } else {
            store[idx] = val;
        }
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

    public void remove(int idx) {

        if (idx < 0 || idx >= store.length) {
            throw new BusinessExceptions("Индекс выходит за пределы массива");
        }

        store[idx] = 0;
        if (idx < size - 1) {
            for (int i = idx; i < size; i++) {
                store[i] = store[i + 1];
            }
            size--;
        }
    }

    public int size() {

        return size;
    }

    public void s() {

        System.out.println(Arrays.toString(store));
    }
}
