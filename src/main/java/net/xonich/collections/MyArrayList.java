package net.xonich.collections;

public class MyArrayList {

    private int size = 0;
    private int[] store = new int[10];

    public int get(int idx) {

        return store[idx];
    }

    public void set(int idx, int val) {


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
    }

    public int size() {

        return size;
    }
}
