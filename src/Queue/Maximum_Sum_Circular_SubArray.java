package Queue;
/*
Problem Statement
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:
Input:

nums = [1,-2,3,-2]

Output:

3

Explanation:

Subarray [3] has a maximum sum of 3.

Example 2:
Input:

nums = [5,-3,5]

Output:

10

Explanation:

Subarray [5,5] has a maximum sum of 5 + 5 = 10.
 */
public class Maximum_Sum_Circular_SubArray {
    public static void main(String[] args) {
        int[] a = {5, -3, 5};
        System.out.println(maxSubArraySumCircular(a));
    }
    public static int maxSubArraySumCircular(int[] a) {
        int max_sum_subArray_In_A_Normal_Array = kadane(a, a.length);
        int max_sum_subArray_In_A_Circular_Array = kadaneVariation(a, a.length);

        if (max_sum_subArray_In_A_Normal_Array > 0) return Math.max(max_sum_subArray_In_A_Normal_Array, max_sum_subArray_In_A_Circular_Array);

        return max_sum_subArray_In_A_Normal_Array;
    }

    private static int kadaneVariation(int[] a, int n) {
        int sum = a[0];
        int minSum = a[0];
        int totalSum = a[0];

        for (int i = 1; i < n; i++) {
            totalSum += a[i];
            sum = Math.min(sum+a[i], a[i]);
            minSum = Math.min(minSum, sum);
        }
        return totalSum - minSum;
    }

    private static int kadane(int[] a, int n) {
        int sum = a[0];
        int maxSum = a[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum+a[i], a[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
