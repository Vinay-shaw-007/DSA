package LinkedList;

/*
Problem Statement
Rotate a given list k places to the right, where k is not a negative number.

Example 1:
Input:
A = 1->2->3->4->5->NULL
B = 2

Output:
4->5->1->2->3->NULL

Example 2:
Input:
A = 1->2->3->4->5->NULL
B = 5

Output:
1->2->3->4->5->NULL
 */

import static LinkedList.ListNode.printLL;

public class Rotate_List {

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
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;
//        n8.next = n9;
//        n9.next = n10;


        printLL(head);
        printLL(rotateRight(head, 10));
    }

    public static ListNode rotateRight(ListNode A, int B) {
        //You can code here

        if (A == null || A.next == null) return A;

        int size = 0;

        ListNode temp = A;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int travel = B;


        if (travel > size) {
            while (travel > size) {
                travel = travel - size;
            }
            System.out.println("while travel = " + travel);
        }

        travel = Math.abs(travel);

        travel = size - travel;


        System.out.println("travel = " + travel);


        if (travel == 0) return A;


        int i = 1;
        temp = A;

        while (temp != null) {
            if (i != travel) {
                temp = temp.next;
            } else break;
            i++;
        }

        if (temp == null) return null;

        ListNode temp2 = temp.next;

        ListNode newHead = temp2;

        temp.next = null;

        while (temp2 != null && temp2.next != null) {
            temp2 = temp2.next;
        }

        if (temp2 == null) return null;
        temp2.next = A;

        return newHead;

    }
//    public static ListNode rotateRight(ListNode A, int B) {
//        //You can code here
//
//        if (A == null || A.next == null) return A;
//        ListNode ans = new ListNode(-1);
//
//        int size = 0;
//
//        ListNode temp = A;
//
//        while (temp != null) {
//            size++;
//            temp = temp.next;
//        }
//
//        temp = A;
//
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//
//        temp.next = A;
//
//
//        return ans.next;
//
//    }
}
