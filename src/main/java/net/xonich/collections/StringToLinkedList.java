package net.xonich.collections;

public class StringToLinkedList {
    private char val;
    private StringToLinkedList next;

    public StringToLinkedList() {}

    public StringToLinkedList(char val) {this.val = val;}

    public StringToLinkedList(char val, StringToLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public StringToLinkedList toLL(String string) {
        StringToLinkedList dummy = new StringToLinkedList();
        StringToLinkedList head = new StringToLinkedList(string.charAt(0));

        dummy.next = head;
        for (int i = 1; i < string.length(); i++) {
            head.next = new StringToLinkedList(string.charAt(i));
            head = head.next;
        }
        return dummy.next;
    }

    public void printList() {
        String res = String.valueOf(val);
        StringToLinkedList temp = next;
        while (temp != null) {
            res += " " + temp.val;
            temp = temp.next;
        }
        System.out.println(res);
    }
}
