package LinkedList;

import static LinkedList.ListNode.printLL;

/*
Problem Statement
Given a linked list A, remove the B-th node from the end of the list and return its head.

Consider the linked list 1->2->3->4->5 with B = 2. The linked list changes to 1->2->3->5 after the second node at the very end is removed.



NOTE: The list's first node should be eliminated if B exceeds the list's size.



NOTE: Try doing it using constant additional space.

Example 1:
Input:

A = 1 -> 2 -> 3 -> 4 -> 5
B = 3

Output:

1 -> 2 -> 4 -> 5

Explanation:

3 is the third last element.

Example 2:
Input:

A = 1 -> 2 -> 3 -> 4 -> 5
B = 7

Output:

2 -> 3 -> 4 -> 5

Explanation:

Since B exceeds the length of the Linked List, remove the First Node i.e. 1
 */
public class Remove_Nth_Node_from_List_End {
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
        printLL(head);
        printLL(removeNthFromEnd(head, 1));
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null) return null;

        ListNode temp = A;

        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        temp = A;
        int travel = size - B;
        if (travel < 1) return A.next;
        int i = 1;
        while (temp != null) {
            if (travel == i) {
                temp.next = temp.next.next;
                break;
            } else {
                temp = temp.next;
            }
            i++;
        }
        return A;
    }
}
