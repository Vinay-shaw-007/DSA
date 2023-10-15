package LinkedList;

/*
Given a linked list, you have to perform the following task:

Extract the alternative nodes starting from second node.
Reverse the extracted list.
Append the extracted list at the end of the original list.
Note: Try to solve the problem without using any extra memory.

Example 1:

Input:
LinkedList = 10->4->9->1->3->5->9->4
Output:
10 9 3 9 4 5 1 4
Explanation:
Alternative nodes in the given linked list are 4,1,5,4. Reversing the alternative nodes from the given list, and then appending them to the end of the list results in a list 10->9->3->9->4->5->1->4.
Example 2:

Input:
LinkedList = 1->2->3->4->5
Output:
1 3 5 4 2
Explanation:
Alternative nodes in the given linked list are 2 and 4. Reversing the alternative nodes from the given list, and then appending them to the end of the list results in a list 1->3->5->4->2.
 */

import static LinkedList.ListNode.printLL;

public class Reverse_alternate_nodes_in_LinkedList {
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


//        printLL(head);
        rearrange(head);

    }
    public static void rearrange(ListNode odd)
    {
        // add your code here

        ListNode head1 = odd;
        ListNode temp1 = head1;

        ListNode head2 = odd.next;
        ListNode temp2 = head1.next;

        while (temp1 != null && temp1.next != null) {
            temp1 = temp1.next.next;
        }

        while (temp2 != null && temp2.next != null) {
            temp2 = temp2.next.next;
        }

        printLL(head1);
        printLL(head2);
    }
}
