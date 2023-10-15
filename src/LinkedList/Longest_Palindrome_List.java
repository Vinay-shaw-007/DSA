package LinkedList;

import static LinkedList.ListNode.printLL;

/*
Problem Statement
Given a linked list , return the length of the longest palindrome list that is present in the given linked list.

Example 1:
Sample Input:

head = [1 -> 2 -> 3 -> 3 -> 2 -> 4]

Sample Output:

4

Explanation:

2 -> 3 -> 3 -> 2 is the length of the longest palindrome in the list.

Example 2:
Sample Input:

head = [1 -> 2 -> 2-> 3 -> 2 -> 4]

Sample Output:

3

Explanation:

2 -> 3 -> 2 is the length of the longest palindrome in the list.
 */
public class Longest_Palindrome_List {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
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
        System.out.println(maxPalindrome(head));
    }
    public static int maxPalindrome(ListNode head) {
        int max = 0;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            int exactCenter = 2 * countElement(prev, next) + 1;
            int notExactCenter = 2 * countElement(curr, next);
            max = Math.max(max, Math.max(exactCenter, notExactCenter));
            prev = curr;
            curr = next;
        }
        return max;
    }

    private static int countElement(ListNode h1, ListNode h2) {
        int count = 0;
        while (h1 != null && h2 != null) {
            if (h1.val != h2.val) break;
            count++;
            h1 = h1.next;
            h2 = h2.next;
        }
        return count;
    }
}
