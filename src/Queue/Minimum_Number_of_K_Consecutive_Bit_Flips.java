package Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement
You are given a binary array nums and an integer k.

A k-bit flip is choosing a subarray of length k from nums and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.

Return the minimum number of k-bit flips required so that there is no 0 in the array. If it is not possible, return -1.

A subarray is a contiguous part of an array.

Example 1:
Input:

nums = [1,1,0], k = 2

Output: -1

Explanation:

No matter how we flip subarrays of size 2, we cannot make the array become [1,1,1].

Example 2:
Input:

nums = [0,1,0], k = 1

Output: 2

Explanation:

Flip nums[0], then flip nums[2].
 */
public class Minimum_Number_of_K_Consecutive_Bit_Flips {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,0,1,1,0};
        int k = 3;
        System.out.println(minKBitFlips(nums, k));
    }
    public static int minKBitFlips(int[] nums, int k) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((q.size() & 1) != 0) nums[i] = nums[i] ^ 1;

            if (nums[i] == 0) {
                if (i + k > nums.length) return -1;
                count++;
                q.offer(i+k-1);
            }
            if (!q.isEmpty() && q.peek() == i) q.poll();
        }
        return count;
    }
}
