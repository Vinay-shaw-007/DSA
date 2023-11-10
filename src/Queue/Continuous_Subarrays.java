package Queue;

import java.util.ArrayDeque;

/*
Problem Statement
You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:

Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
Return the total number of continuous subarrays.

Example 1:
Input:

nums = [5,4,2,4]

Output:

8

Explanation:

Continuous subarray of size 1: [5], [4], [2], [4].
Continuous subarray of size 2: [5,4], [4,2], [2,4].
Continuous subarray of size 3: [4,2,4].
Thereare no subarrys of size 4.
Total continuous subarrays = 4 + 3 + 1 = 8.
It can be shown that there are no more continuous subarrays.

Example 2:
Input:

nums = [1,2,3]

Output:

6

Explanation:

Continuous subarray of size 1: [1], [2], [3].
Continuous subarray of size 2: [1,2], [2,3].
Continuous subarray of size 3: [1,2,3].
Total continuous subarrays = 3 + 2 + 1 = 6.
 */
public class Continuous_Subarrays {
    public static void main(String[] args) {
        int[] nums = {5,4,2,4};
        System.out.println(continuousSubArrays(nums));
    }
    public static long continuousSubArrays(int[] nums) {
        long count = 0;

        ArrayDeque<Integer> min = new ArrayDeque<>();
        ArrayDeque<Integer> max = new ArrayDeque<>();

        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!min.isEmpty() && min.getLast() > nums[r]) min.pollLast();

            min.offerLast(nums[r]);

            while (!max.isEmpty() && max.getLast() < nums[r]) max.pollLast();

            max.offerLast(nums[r]);

            while (max.getFirst() - min.getFirst() > 2) {
                if (min.getFirst() == nums[l]) min.pollFirst();
                if (max.getFirst() == nums[l]) max.pollFirst();
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }
}
