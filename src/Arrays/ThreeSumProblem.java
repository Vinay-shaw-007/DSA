package Arrays;

import java.util.*;

public class ThreeSumProblem {
    public static void main(String[] args) {

//        int[] nums = {-2, 0, 1, 2, 1};
        int[] nums = {8, -3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //You can code here

        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> temp = twoSum(nums, -nums[i], i + 1);
            for (List<Integer> list : temp) {
                list.add(0, nums[i]);
                list.add(1, nums[i + 1]);
                ans.add(list);
            }
        }
        return ans;
    }

    private static List<List<Integer>> twoSum(int[] nums, int k, int startFrom) {
        int l = startFrom;
        int r = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (l < r) {
            if (l > startFrom && nums[l] == nums[l - 1]) {
                l++;
                continue;
            }
            if (r > nums.length - 1 && nums[r] == nums[r + 1]) {
                r--;
                continue;
            }
            if (nums[l] + nums[r] > k) r--;
            else if (nums[l] + nums[r] < k) l++;
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[l]);
                temp.add(nums[r]);
                ans.add(temp);
                l++;
                r--;
            }
        }
        return ans;
    }

}
