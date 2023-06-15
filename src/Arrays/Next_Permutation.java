package Arrays;

import java.util.Arrays;

public class Next_Permutation {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };

        nextPermutation(nums);
        for (int nums2 : nums) {
            System.out.print(nums2 + ",");
        }
    }

    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        if (n == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }

        int idx = -1;

        for (int i = n - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                idx = i - 1;
                break;
            }
        }

        if (idx == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i = n - 1; i > idx; i++) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        Arrays.sort(nums, idx + 1, nums.length);
    }
}
