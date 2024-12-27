package net.xonich.collections;

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val != curr.next.val) {
                curr = curr.next;
            } else {
                curr.next = curr.next.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
