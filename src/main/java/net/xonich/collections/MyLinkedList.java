package net.xonich.collections;

public class MyLinkedList {

    private int size;
    private Node head;

    public Node addFirstNode(String val) {
        if (head == null) {
            head = new Node(val);
        } else {
            head = new Node(val, head);
        }
        size++;
        return head;
    }

    public Node addLastNode(String val) {

        if (head == null) {
            head = new Node(val);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(val);
        }
        size++;
        return head;
    }

    public int getSize() {

        return size;
    }

    public static void main(String[] args) {

        MyLinkedList mll = new MyLinkedList();

        mll.addFirstNode("a");
        mll.addFirstNode("J");
        mll.addLastNode("v");
        mll.addLastNode("a");
        System.out.println(mll.getSize());
    }
}
