package Arrays;

import java.util.*;

public class Integers_Containing_Only_1_2_and_3 {
    public static void main(String[] args) {
        int[] arr = {8, 9, 123, 321, 879320142};
        System.out.println(find123Digits(arr, arr.length));
    }
    public static List<Integer> find123Digits(int[] arr, int n)
    {
        //You can code here
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > 100) {
                if (isContains123(arr[i])) {
                    ans.add(arr[i]);
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
            return ans;
        }
        Collections.sort(ans);
        return ans;

    }

    private static boolean isContains123(int i) {
        boolean[] digit = new boolean[3];
        int count = 0;
        while (i > 0) {
            int d = i % 10;
            if (d == 1 && !digit[d - 1]) {
                digit[d - 1] = true;
                count++;
            } else if (d == 2 && !digit[d - 1]) {
                digit[d - 1] = true;
                count++;
            } else if (d == 3 && !digit[d - 1]) {
                digit[d - 1] = true;
                count++;
            }
            if (count == 3) return true;
            i /= 10;
        }
        return false;
    }
}
