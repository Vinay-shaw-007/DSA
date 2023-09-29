package LinkedList;

import static LinkedList.ListNode.printLL;

public class Merge_Two_SortedList {
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
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        printLL(head);
        printLL(n6);
        printLL(mergeTwoSortedList(head, n6));
//        mergeTwoSortedList(head, n6);
    }
    private static ListNode mergeTwoSortedList(ListNode leftNodeSorted, ListNode rightNodeSorted) {

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while (leftNodeSorted != null && rightNodeSorted != null) { // Use && instead of ||
            if (leftNodeSorted.val <= rightNodeSorted.val) {
                temp.next = leftNodeSorted;
                leftNodeSorted = leftNodeSorted.next;
            } else {
                temp.next = rightNodeSorted;
                rightNodeSorted = rightNodeSorted.next;
            }
            temp = temp.next;
        }

        // Append the remaining nodes from either list (if any)
        if (leftNodeSorted != null) {
            temp.next = leftNodeSorted;
        } else {
            temp.next = rightNodeSorted;
        }

        return ans.next;
    }
}
