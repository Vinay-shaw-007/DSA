package LinkedList;

import static LinkedList.ListNode.printLL;

/*
Problem Statement
Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input:

A = [1, 4, 3, 2, 5, 2]
B = 3

Output:

[1, 2, 2, 4, 3, 5]

Example 2:
Input:

A = [1, 2, 3, 1, 3]
B = 2

Output:

[1, 1, 2, 3, 3]
 */
public class Partition_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(2);
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
        printLL(partition(head, 4));
    }
    public static ListNode partition(ListNode A, int B) {
        //You can code here 1 4 3 2 5 5

        ListNode ans = new ListNode(-1);

        ans.next = A;

        ListNode small = ans;

        ListNode temp = A, prev = null;

        while (temp != null) {
            if (temp.val < B) {
                if (prev == null || prev == small) {
                    small = small.next;
                    prev = temp;
                    temp = temp.next;
                } else {
                    ListNode sNext = small.next;
                    ListNode tNext = temp.next;
                    small.next = temp;
                    temp.next = sNext;
                    temp = tNext;
                    prev.next = temp;
                    small = small.next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        return ans.next;
    }
}
