package net.xonich.collections;

public class LinkedListDemo {

    public static class Node {

        char val;
        Node next;

        public Node(char val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node stringToLinkedList(String str) {

        Node head = new Node(str.charAt(0), null);
        Node cur = head;
        for (int i = 1; i < str.length(); i++) {
            cur.next = new Node(str.charAt(i), null);
            cur = cur.next;
        }

        return head;
    }

    public static String linkedListToString(Node head) {

        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {

            sb.append(cur.val);
            cur = cur.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Node head = stringToLinkedList("cocacola");

        Node head2 = removeHead(head);

        System.out.println();
    }

    public static Node removeHead(Node head) {

        Node result = head.next;
        head.next = null;

        return result;
    }
}
