package LinkedList;

import static LinkedList.ListNode.printLL;

/*
Problem Statement
Given are an integer B and a linked list A of length N.

From the middle of the Linked List A toward the beginning, you must determine the value of the Bth node.

Return -1 if such an element is not present.



NOTE: N is the total number of nodes in the list, and the position of the middle node is (N/2)+1.

Example 1:
Input:
A: 1 -> 2 -> 3 -> 4 -> 5
B: 2

Output:
1

Example 2:
Input:
A: 1 -> 2 -> 3 -> 4 -> 5
B: 0

Output:
3
 */
public class Kth_Node_From_Middle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println("Answer = "+kthNode(head, 1));
    }
    public static int kthNode(ListNode head, int B) {
        //You can code here
        if (head == null) return -1;
        ListNode middle = findMiddle(head);
        ListNode r1 = reverse(head, middle);
        printLL(r1);
        int i = 0;
        while (r1 != null) {
            System.out.println(i+" == "+B+", r1 = "+r1.val);
            if (i == B) return r1.val;
            r1 = r1.next;
            i++;
        }
        return -1;
    }

    static ListNode reverse(ListNode head, ListNode middle) {
        ListNode prev = head;
        ListNode curr = head.next;
        head.next = null;
        while (prev != middle) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
