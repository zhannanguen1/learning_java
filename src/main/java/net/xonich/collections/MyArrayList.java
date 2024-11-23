package net.xonich.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    private void ensureIndexForAdd(int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Индекс " + idx + " выходит за пределы диапазона " + "0 .. " + size);
        }
    }

    public void set(int idx, int val) {
        ensureIndex(idx);
        store[idx] = val;
    }

    public void add(int val) {

        resizeIfNeeded();
        store[size] = val;
        size++;
    }

    public void add(int idx, int val) {

        ensureIndexForAdd(idx);

        resizeIfNeeded();

        for (int i = size - 1; i >= idx; i--) {
            store[i + 1] = store[i];
        }
        store[idx] = val;
        size++;

    }

    private void resizeIfNeeded() {
        if (size >= store.length) {

            int[] newStore = new int[store.length * 2];
            System.arraycopy(store, 0, newStore, 0, store.length);
            store = newStore;
        }
    }

    public void remove(int idx) {

        ensureIndex(idx);

        store[idx] = 0;

        for (int i = idx; i < size - 1; i++) {
            store[i] = store[i + 1];
        }
        size--;
        store[size] = 0;
    }

    public int size() {

        return size;
    }

    public Iterator<Integer> iterator() {

        return new Itr();
    }

    private class Itr implements Iterator<Integer> {

        private int idx = -1;
//        private MyArrayList myArrayList;

//        public Itr(MyArrayList myArrayList) {
//            this.myArrayList = myArrayList;
//        }

        @Override
        public void remove() {
            ensureIndex(idx);
            if (idx < size - 1) {
                MyArrayList.this.remove(idx);
            }
        }

        @Override
        public boolean hasNext() {

            return size > idx + 1;
        }

        @Override
        public Integer next() {

            if (hasNext()) {
                idx++;
                return store[idx];
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean isFirst = true;
        for (int i = 0; i < size; i++) {
            if (!isFirst) {
                sb.append(", ");
            }
            sb.append(store[i]);
            isFirst = false;
        }
        sb.append("]");
        return sb.toString();
    }
}


















