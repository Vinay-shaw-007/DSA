package LinkedList;

import static LinkedList.ListNode.printLL;

public class ReorderList {
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
        reorderList(head);
        printLL(head);

    }


    public static void reorderList(ListNode head) {
        //You can code here
        ListNode h = head;
        ListNode t = findTailOfGivenHead(head);

        System.out.println("head ");
        printLL(h);
        System.out.println("tail");
        printLL(t);

        ListNode nh = h.next;
        ListNode nt = t.next;

        while (nt != null) {

            h.next = t;
            t.next = nh;

            h = nh;
            t = nt;

            nh = nh.next;
            nt = nt.next;
        }
    }

    public static ListNode findTailOfGivenHead(ListNode head) {
        ListNode middle = findMiddle(head);
        return reverseLinkedList(middle);
    }
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode curr = head.next;
        head.next = null;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
