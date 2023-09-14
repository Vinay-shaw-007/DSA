package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] a = {22, 7, 1, 3, 11, 20, 19};
        System.out.println(minimumAbsDifference(a));
    }
    public static List<List< Integer>> minimumAbsDifference(int[] arr)
    {
        //You can code here
        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, (arr[i] - arr[i - 1])); // 2 8 9 11 12
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) == minDiff) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                ans.add(list);
            }
        }

        return ans;
    }
}
