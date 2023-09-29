package Dev_Session;

import LinkedList.ListNode;

import static LinkedList.ListNode.printLL;

public class EvenReverse {
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
        printLL(evenReverse(head));

    }

    public static ListNode evenReverse(ListNode A) {
        //You can code here

        if (A == null || A.next == null) return A;

        ListNode t1 = A;
        ListNode odd = A;

        ListNode t2 = A.next;
        ListNode even = A.next;

        while (t2 != null) {
            t1.next = t2.next;
            t1 = t2;
            t2 = t2.next;
        }

        even = reverse(even);

        ListNode nextOdd = odd.next;
        ListNode nextEven = even.next;

        while (odd != null && even != null) {
            odd.next = even;
            odd = nextOdd;
            if (nextOdd != null)
                nextOdd = nextOdd.next;

            even.next = odd;
            even = nextEven;
            if (nextEven != null)
                nextEven = nextEven.next;
        }


        return A;
    }

    private static ListNode reverse(ListNode head) {
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
}
