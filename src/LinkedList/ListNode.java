package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        head.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
