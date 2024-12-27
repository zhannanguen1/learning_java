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

        if (size == 1) {
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
        private Node<E> prev;
        private Node<E> curr = head;

        @Override
        public boolean hasNext() {

            return curr != null;
        }

        @Override
        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            prev = curr;
            E val = curr.val;
            curr = curr.next;
            return val;
        }

        @Override
        public void remove() {
            if (prev == null) {
                throw new IllegalStateException();
            }

            if (prev == head) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            } else {
                Node<E> temp = head;
                while (temp != null && temp.next != prev) {
                    temp = temp.next;
                }
                if (temp != null) {
                    temp.next = prev.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                }
            }
            prev = null;
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
