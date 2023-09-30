package LinkedList;

/*
Problem Statement
Given are an integer B and a linked list A of length N.

Each alternate B node in the linked list A must be reversed.

Example 1:
Input:

A = 1 -> 2 -> 3 -> 4 ->  5 -> 6 -> 7 -> 8 -> 9
B = 3

Output:

3 -> 2 -> 1 -> 4 ->  5 -> 6 -> 9 -> 8 -> 7

Example 2:
Input:

A = 1 -> 2 -> 3 -> 4 ->  5 -> 6 -> 7 -> 8 -> 9
B = 1

Output:

1 -> 2 -> 3 -> 4 ->  5 -> 6 -> 7 -> 8 -> 9
 */


import static LinkedList.ListNode.printLL;

public class Reverse_Alternate_K_Nodes {
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
        printLL(solve(head, 2));
    }
    public static ListNode solve(ListNode A, int B) {
        //You can code here

        ListNode end = A;

        ListNode dummy = new ListNode(-1);

        dummy.next = A;

        ListNode beforeStart = dummy;

        int i = 1;

        boolean startReverse = true;

        while (end != null) {
            if (i % B == 0) {

                if (startReverse) {

                    ListNode start = beforeStart.next, afterEnd = end.next;

                    reverse(start, end);

                    beforeStart.next = end;

                    start.next = afterEnd;

                    beforeStart = start;

                    end = afterEnd;

                    startReverse = false;

                } else {
                    beforeStart = end;
                    startReverse = true;
                    end = end.next;
                }

            } else {
                end = end.next;
            }
            i++;
        }

        return dummy.next;

    }

    private static void reverse(ListNode start, ListNode end) {
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
