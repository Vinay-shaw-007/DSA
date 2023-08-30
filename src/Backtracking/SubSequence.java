package Backtracking;

import java.util.*;

public class SubSequence {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        for (ArrayList<Integer> item : AllSubsets(nums)) {
            System.out.println(item);
        }
    }

    private static ArrayList<ArrayList<Integer>> AllSubsets(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(nums);
        helper(nums, ans, list, 0);
        return ans;
    }

    public static void helper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, int index) {
        ans.add(new ArrayList<>(list));

        for (int i = index; i < nums.size(); i++) {
            // this line is responsible for removing duplicates subset because it is checking if the current element is same as previous then don't add in the list move to the next element.
            if (i > index && Objects.equals(nums.get(i), nums.get(i - 1))) continue;
            list.add(nums.get(i));
            helper(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> list) {
        for (ArrayList<Integer> i : list)
            System.out.println(i);
    }

}
