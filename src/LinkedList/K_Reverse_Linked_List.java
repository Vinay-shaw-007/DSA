package LinkedList;


import java.util.List;

public class K_Reverse_Linked_List {
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

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        printLL(head);
//        printLL(reverseLL(head, n3));

//        reverseKGroup(head, 4);
        printLL(reverseKGroup(head, 4));

    }

    public static ListNode reverseKGroup(ListNode originalHead, int k) {
        //You can code here
        if (originalHead == null || originalHead.next == null || k == 1) return originalHead;
        ListNode dummy = new ListNode(-1);
        dummy.next = originalHead;
        ListNode beforeStart = dummy, end = originalHead;


        int i = 1;

        while (end != null) {
            if (i % k == 0) {
                ListNode start = beforeStart.next;
                ListNode afterEnd = end.next;

                reverseLL(start, end);

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

    private static void reverseLL(ListNode head, ListNode tail) {
        if (head == null || head.next == null) return;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (prev != tail) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) next = next.next;
        }
    }

    private static void printLL(ListNode head) {
        while (head != null) {
            while (head != null) {
                System.out.print(head.val + " -> ");
                head = head.next;
            }
            System.out.println();
        }
    }
}