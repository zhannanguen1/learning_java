package net.xonich.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;



    public void addFirst(E val) {
        head = new Node<E>(val, head);
        size++;

        if(size == 1) {
            tail = head;
        }

    }

    public void addLast(E val) {

        tail.next = new Node<>(val);
        tail = tail.next;
        size++;
    }

    public int getSize() {

        return size;
    }

    @Override
    public Iterator<E> iterator() {

        return new Itr();
    }

    private class Itr implements Iterator<E> {


        private Node<E> curr = null;
        private Node<E> prev = null;

        @Override
        public boolean hasNext() {

            return curr.next != null;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {

            if (curr!=null && hasNext()) {
                prev = curr;
                curr = curr.next;
            } else {
                curr = head;
            }
            return (E) curr.val;
        }

        @Override
        public void remove() throws NoSuchElementException {

            if (curr == null) {
                throw new NoSuchElementException();
            }
            if (prev == null) {
                head = head.next;
                curr = null;
            } else {
               prev.next = curr.next;
               curr = prev;
            }
            size--;
        }
    }

    private static class Node<E> {

        E val;
        Node<E> next;

        public Node() {
        }

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
}
