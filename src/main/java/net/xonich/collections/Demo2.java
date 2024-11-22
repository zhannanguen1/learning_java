package net.xonich.collections;

public class Demo2 {

    public static void main(String[] args) {
        
        ReverseList reverseList = new ReverseList();
        int[] collect = {1, 2, 3, 4, 5};
        ListNode headLL = createLinkedList(collect);
        ListNode reversHead = reverseList.reverseList(headLL);
        printList(reversHead);

        int[] digits1 = {2, 4, 3};
        int[] digits2 = {5, 6, 4};
        ListNode l1 = createLinkedList(digits1);
        ListNode l2 = createLinkedList(digits2);

        ListNode head = AddTwoNumbers.addTwoNumbers(l1, l2);
        printList(head);
    }

    public static ListNode createLinkedList(int[] digits) {
        ListNode prev = new ListNode(0);
        ListNode current = prev;
        for (int digit : digits) {
            current.next = new ListNode(digit);
            current = current.next;
        }
        return prev.next;
    }

    static void printList(ListNode head) {
        StringBuilder result = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            result.append(current.val);
            if (current.next != null) {
                result.append(" -> "); // Форматирование для наглядности
            }
            current = current.next;
        }
        System.out.println(result);
    }
}
