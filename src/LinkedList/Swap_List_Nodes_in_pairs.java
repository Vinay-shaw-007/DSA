package LinkedList;

import static LinkedList.ListNode.printLL;

public class Swap_List_Nodes_in_pairs {
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
        printLL(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode A) {
        //You can code here
        if (A == null || A.next == null) return A;
        ListNode dummy = new ListNode(-1);
        dummy.next = A;
        ListNode beforeStart = dummy;
        ListNode end = A;

        int i = 1;

        while (end != null) {
            if (i % 2 == 0) {
                ListNode start = beforeStart.next, afterEnd = end.next;

                reverse(start, end);

                beforeStart.next = end;

                start.next = afterEnd;

                beforeStart = start;

                end = afterEnd;
            } else {
                end = end.next;
            }
            i++;
        }
        return dummy.next;
    }

    private static void reverse(ListNode start, ListNode end) {
        if (start == null || start.next == null) return;
        ListNode prev = start;

        ListNode curr = start.next;

        start.next = null;

        while (prev != end) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
    }
}
