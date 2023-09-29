package LinkedList;

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
        printLL(sortList(head));
    }

    public static ListNode sortList(ListNode A) {//1 2 3 4
        //You can code here

        if (A == null || A.next == null) return A;

        ListNode mid = findMiddle(A);

        ListNode leftNode = A;//1 2 3 4
        ListNode rightNode = mid.next;//3 4
        mid.next = null;

        System.out.print("LeftNode = ");
        printLL(leftNode);

        leftNode = sortList(leftNode);
        rightNode = sortList(rightNode);



        return mergeTwoSortedList(leftNode, rightNode);
    }

    private static ListNode mergeTwoSortedList(ListNode leftNode, ListNode rightNode) {

        if(leftNode==null)
            return rightNode;

        if(rightNode==null)
            return leftNode;


        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val <= rightNode.val) {
                temp.next = leftNode;
                leftNode = leftNode.next;
            } else {
                temp.next = rightNode;
                rightNode = rightNode.next;
            }
            temp = temp.next;
        }

        if (leftNode != null) {
            temp.next = leftNode;
        } else {
            temp.next = rightNode;
        }

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
