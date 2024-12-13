package net.xonich.collections;

public class MyLinkedListStr {

    private int size;
    private Node head;
    private Node tail;

    public void addFirst(String val) {

        head = new Node(val, head);
        size++;

    }

    public void addLast(String val) { //toDO оптимизировать

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val);
        size++;

    }

    public int getSize() {

        return size;
    }

    private static class Node {

        String val;
        Node next;

        public Node() {
        }

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
