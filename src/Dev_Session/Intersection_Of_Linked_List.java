package Dev_Session;

import LinkedList.ListNode;

public class Intersection_Of_Linked_List {
    public static void main(String[] args) {

    }
    public static int findIntersection(ListNode firstHead, ListNode secondHead) {
        int h1Size = 0, h2Size = 0;

        ListNode temp1 = firstHead;
        ListNode temp2 = secondHead;

        while (temp1 != null) {
            h1Size++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            h2Size++;
            temp2 = temp2.next;
        }

        temp1 = firstHead;
        temp2 = secondHead;

        if (h1Size > h2Size) {
            int i = 1;
            while (temp1 != null) {
                if (i > Math.abs(h2Size - h1Size)) {
                    temp1 = temp1.next;
                    i++;
                }
            }

        } else if (h1Size < h2Size) {
            int i = 1;
            while (temp2 != null) {
                if (i > Math.abs(h2Size - h1Size)) {
                    temp2 = temp2.next;
                    i++;
                }
            }
        }

        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp2.val;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return -1;
    }
}
