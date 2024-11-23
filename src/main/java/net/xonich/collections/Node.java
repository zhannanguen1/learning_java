package net.xonich.collections;

public class Node {

    String val;
    Node next;

    public Node() {}
    public Node(String val) {this.val = val;}
    public Node(String val, Node next) {this.val = val; this.next = next;}
}
