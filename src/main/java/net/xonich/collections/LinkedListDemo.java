package net.xonich.collections;

public class LinkedListDemo {

    public static class Node {

        char val;
        Node next;

        public Node() {
        }

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
//        Node head2 = removeHead(head);
//        Node head2 = removeAllNodesWithGivenValue(head, 'c');
        Node head2 = removeTail(head);

        System.out.println();
    }

    public static Node removeHead(Node head) {

        Node result = head.next;
        head.next = null;

        return result;
    }

    public static Node removeTail(Node head) { //ToDO если список короткий. Доделать

        Node cur = head;

        while (cur.next.next != null) {

            cur = cur.next;
        }
        cur.next = null;

        return head;
    }

    public static Node removeAllNodesWithGivenValue(Node head, char val) {

        if (head == null) {
            return null;
        }

        Node prev = head;
        Node cur = head.next;
        while (cur != null) {

//             cur.next.val == val
//                cur.next = cur.next.next;
            if (cur.val == val) {
                prev.next = cur.next;
            }
            prev = cur;
            cur = cur.next;

        }

        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
