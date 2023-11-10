package Bit_Manipulation;
/*
Given an array of N integers, find the sum of xor of all pairs of numbers in the array arr. In other words, select all possible pairs of i and j from 0 to N-1 (i<j) and determine sum of all (arri xor arrj).

Example 1:

Input : arr[ ] = {7, 3, 5}
Output : 12
Explanation:
All possible pairs and there Xor
Value: ( 3 ^ 5 = 6 ) + (7 ^ 3 = 4)
 + ( 7 ^ 5 = 2 ) =  6 + 4 + 2 = 12
Example 2:

Input : arr[ ] = {5, 9, 7, 6}
Output :  47
Explanation:
All possible pairs and there Xor
Value: (5 ^ 9 = 12) + (5 ^ 7 = 2)
 + (5 ^ 6 = 3) + (9 ^ 7 = 14)
 + (9 ^ 6 = 15) + (7 ^ 6 = 1)
 = 12 + 2 + 3 + 14 + 15 + 1 = 47
 */
public class Sum_of_XOR_of_all_pairs {
    public static void main(String[] args) {
        int[] arr = {7, 3, 5};
        System.out.println(sumXOR(arr, 3));
    }

    public static long sumXOR (int[] arr, int n) {
        long ans = 0;

        for (int i = 0; i < 32; i++) {
            long noOfOnes = 0;
            for (int e : arr) {
                if ((e & (1 << i)) != 0) noOfOnes++;
            }
            ans += noOfOnes * (n - noOfOnes) * (1 << i);
        }

        return ans;
    }
}
