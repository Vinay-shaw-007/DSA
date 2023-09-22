package Arrays;

import java.util.*;

public class Find_Pairs_Whose_Sum_is_Present_in_Array {
    public static void main(String[] args) {
//        int[] arr = {1, 9, 10, 8, 2, 2, 10, 7, 9, 1};
        int[] arr = {2, 8, 7, 1, 5};
        System.out.println(findPair(arr));
    }

    public static List<List<Integer>> findPair(int[] arr) {
        //You can code here
        Arrays.sort(arr);
        for (int i : arr)
            System.out.print(i+" ");
        System.out.println();
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = n - 1; i >= 2; i--) {
            if (i < n - 1 && arr[i] == arr[i + 1]) continue;
            List<List<Integer>> lists = twoSum(arr, arr[i], i - 1);
            for (List<Integer> list : lists)
                ans.add(list);
        }
        sortList(ans);
        return ans;
    }

    public static List<List<Integer>> twoSum(int[] arr, int target, int end) {
        int r = end;
        int l = 0;
        List<List<Integer>> ans = new ArrayList<>();

        while (l < end && r >= 0) {
            if (l > 0 && arr[l] == arr[l - 1]) {
                l++;
                continue;
            }
            if (r < arr.length && arr[r] == arr[r + 1]) {
                r--;
                continue;
            }
            if (arr[l] + arr[r] > target) r--;
            else if (arr[l] + arr[r] < target) l++;
            else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[l]);
                list.add(arr[r]);
                ans.add(list);
                l++;
                r--;
            }
        }
        return ans;
    }

    public static void sortList(List<List<Integer>> ans) {
        ans.sort((l1, l2) -> {
            if ((int) l1.get(0) != l2.get(0)) {
                return Integer.compare(l1.get(0), l2.get(0));
            }
            return Integer.compare(l1.get(1), l2.get(1));
        });
    }
}
