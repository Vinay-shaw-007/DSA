package Arrays;

import java.util.ArrayList;

/*
Problem Statement
You have an array A[] with n elements. We have two types of operation available on this array:
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You must determine whether it is possible to convert array A to size 1,
containing a single element equal to 0 after several splits and/or merge? Print 1 if it is possible, and 0 otherwise.



Example 1:
Input:

n = 2

A = [9, 17]



Output:

1

Example 2:
Input:

n = 1

A = [1]

Output:

0
 */
public class Interesting_Array {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println("Answer = " + isInteresting(a));
    }

    public static int isInteresting(int[] arr) {
        //You Can Code Here

        int sum = 0;

        for (int j : arr) {
            if (j % 2 == 0) continue;
            int a = j / 2;
            int b = a + 1;
            sum ^= (a ^ b);
        }
        System.out.println("Sum = " + sum);

        if (sum % 2 == 0) return 1;

        return 0;
    }

//    public static int isInteresting(int[] arr) {
//        //You Can Code Here
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i : arr) {
//            if (i % 2 != 0) {
//                list.add(i);
//            }
//        }
//
//        int sum = 0;
//
//        for (int i = 0; i < list.size(); i++) {
//            int a = list.get(i) / 2;
//            int b = a + 1;
//            sum ^= (a ^ b);
//            System.out.println("i = " + list.get(i) + " xor = " + (a ^ b) + " a = " + a + " b = " + b);
//            list.set(i, a ^ b);
//        }
//
//        System.out.println("List = " + list);
//        System.out.println("Sum = " + sum);
//
//        if (sum % 2 == 0) return 1;
//
//        return 0;
//    }
}
