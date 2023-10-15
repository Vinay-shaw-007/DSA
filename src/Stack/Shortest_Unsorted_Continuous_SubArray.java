package Stack;

/*
Problem Statement
You must identify a continuous subarray within an integer array nums such that, if you sort this continuous subarray only in non-decreasing order,
the entire array will also be sorted in non-decreasing order.

Give the length of the shortest such subarray.

Example 1:
Input: nums = [1, 4, 2, 3, 5]
Output: 3
Explanation: You need to sort [4, 2, 3] in ascending order to make the whole array sorted in ascending order.

Example 2:
Input: nums = [1, 2, 3]
Output: 0
Explanation: The array is already sorted in ascending order.
 */

import java.util.ArrayDeque;

public class Shortest_Unsorted_Continuous_SubArray {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 3, 5, 9};
//        int[] nums = {1,2,9,8,7,10};
        System.out.println(findUnsortedSubarray(nums, 0));
        System.out.println(findUnsortedSubarray(nums));
    }

    // using stack
    public static int findUnsortedSubarray(int[] nums) {
        //You can code here
        ArrayDeque<Integer> st = new ArrayDeque<>();

        int right = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                right = i;
                min = Math.min(min, nums[i]);
            } else
                st.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) return right - i + 1;
        }
        return 0;
    }

    // without using stack
    public static int findUnsortedSubarray(int[] nums, int dummy) {
        //You can code here

        int right = 0, min = Integer.MAX_VALUE,  maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxSoFar > nums[i]) {
                right = i;
                min = Math.min(min, nums[i]);
            }
            maxSoFar = Math.max(maxSoFar, nums[i]);

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) return right - i + 1;
        }
        return 0;
    }
}
