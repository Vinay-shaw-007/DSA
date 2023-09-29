package LinkedList;

import java.util.List;

import static LinkedList.ListNode.printLL;

public class Reverse_Linked_List_II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        printLL(head);

        printLL(reverseBetween(head, 3, 10));
    }
    public static ListNode reverseBetween(ListNode A, int m, int n) {
        //You can code here
        ListNode dummy = new ListNode(-99);
        dummy.next = A;
        ListNode beforeStart = dummy;
        int i = 1;
        while (beforeStart != null) {
            if (m == i) {
                beforeStart.next = reverseASmallLL(beforeStart.next, m,n);
                break;
            } else {
                beforeStart = beforeStart.next;
            }
            i++;
        }
        return dummy.next;
    }

    private static ListNode reverseASmallLL(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        int i = m;
        while (curr != null && i < n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        head.next = curr;
        return prev;
    }
}
