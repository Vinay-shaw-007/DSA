package Arrays;

import java.util.*;

public class Find_All_Four_Sum_Numbers {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 7, 8, 10};
        System.out.println(fourSum(nums, 23));
    }
    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                List<List<Integer>> lists = twoSum(arr, arr[i]+arr[j], k, j + 1);
                for (List<Integer> list : lists) {
                    list.add(0, arr[i]);
                    list.add(1, arr[j]);
                    ans.add((ArrayList<Integer>) list);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> twoSum(int[] arr, int sum, int k, int l) {
        List<List<Integer>> ans = new ArrayList<>();
        int r = arr.length-1;
        while (l < r) {
            if (arr[l]+arr[r]+sum > k) r--;
            else if (arr[l]+arr[r]+sum < k) l++;
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[l]);
                temp.add(arr[r]);
                ans.add(temp);
                l++;
                r--;
            }
        }
        return ans;
    }
}
