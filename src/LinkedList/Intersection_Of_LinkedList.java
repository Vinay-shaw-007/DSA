package LinkedList;

public class Intersection_Of_LinkedList {
    public static void main(String[] args) {

    }
    public static int findIntersection(ListNode firstHead, ListNode secondHead) {
        //You can code here

        int h1Size = 0, h2Size = 0;
        ListNode t1 = firstHead, t2 = secondHead;
        while (t1 != null) {
            h1Size++;
            t1 = t1.next;
        }

        while (t2 != null) {
            h2Size++;
            t2 = t2.next;
        }

        t1 = firstHead; t2 = secondHead;

        if (h1Size > h2Size) {

            int i = 1;

            while (t1 != null) {
                if (i > Math.abs(h2Size - h1Size)) break;
                t1 = t1.next;
                i++;
            }

        } else if (h1Size < h2Size) {

            int i = 1;

            while (t2 != null) {
                if (i > Math.abs(h2Size - h1Size)) break;
                t2 = t2.next;
                i++;
            }

        }

        while (t1 != null && t2 != null) {
            if (t1 == t2) return t1.val;
            t1 = t1.next;
            t2 = t2.next;
        }
        return -1;

    }
}
