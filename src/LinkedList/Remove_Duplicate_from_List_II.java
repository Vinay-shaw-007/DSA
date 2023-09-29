package LinkedList;

import static LinkedList.ListNode.printLL;

public class Remove_Duplicate_from_List_II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printLL(head);
        ListNode newHead = deleteDuplicates(head);
        printLL(newHead);
    }

    public static ListNode deleteDuplicates(ListNode originalHead) {
        ListNode head = originalHead;
        ListNode ans = null, temp = originalHead;

        while (head != null) {
            boolean isDuplicate = false;
            while (head.next != null && head.val == head.next.val) {
                isDuplicate = true;
                head = head.next;
            }

            if (!isDuplicate) {
                if (ans == null) {
                    ans = temp = head;
                } else {
                    temp.next = head;
                    temp = head;
                }
            }

            head = head.next;
        }
        if (temp != null) {
            temp.next = null;
        }
        return ans;
    }

}
