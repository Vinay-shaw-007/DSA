package Dev_Session;

import LinkedList.ListNode;

import static LinkedList.ListNode.printLL;

public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(21);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(14);
        ListNode n5 = new ListNode(51);
        ListNode n6 = new ListNode(65);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(80);
        ListNode n9 = new ListNode(19);
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
        printLL(mergeSort(head));

    }

    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = mergeSort(left);

        right = mergeSort(right);

        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left != null)
            temp.next = left;
        else
            temp.next = right;

        return ans.next;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode temp = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return temp;
    }
}
