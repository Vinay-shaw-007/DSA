package Backtracking;

import java.util.*;

public class PermutationOfAnArray {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        for (List<Integer> item : permute(nums))
            System.out.println(item);
    }

    public static List<List<Integer>> permute(int[] nums) {
        //You can code here
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list, 0, nums.length - 1);
        sortList(list);

        return list;
    }

    public static void helper(int[] nums, List<List<Integer>> list, int l, int r) {
        if (l == r) {
            List<Integer> l1 = new ArrayList<>();
            for (int i : nums)
                l1.add(i);
            list.add(l1);
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(nums, i, l);
            helper(nums, list, l + 1, r);
            swap(nums, i, l);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortList(List<List<Integer>> list) {
        list.sort((l1, l2) -> {
            int minLength = Math.min(l1.size(), l2.size());
            for (int i = 0; i < minLength; i++) {
                int comparisonResult = Integer.compare(l1.get(i), l2.get(i));
                if (comparisonResult != 0) {
                    return comparisonResult;
                }
            }
            return Integer.compare(l1.size(), l2.size());
        });
    }

}
