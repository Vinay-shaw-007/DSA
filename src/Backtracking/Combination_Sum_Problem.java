package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_Problem {
    public static void main(String[] args) {
        int[] n = {8, 1, 3, 7, 2, 1, 5};
        for (List<Integer> integers :
                combinationSum2(n, 12)) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //You can code here
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, list, candidates, target, 0);
        return ans;
    }

    public static void helper(List<List<Integer>> ans, List<Integer> list, int[] input, int x, int index) {

        if (x < 0) return;

        if (x == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < input.length; i++) {
            if (i > index && input[i] == input[i - 1]) continue;
            list.add(input[i]);
            helper(ans, list, input, x - input[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
