package Binary_Search;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Problem Statement
You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.

Example 1:
Input:
n=5
k=3
stalls = [1 2 4 8 9]
Output:
3
Explanation:
The first cow can be placed at stalls[0],
the second cow can be placed at stalls[2] and
the third cow can be placed at stalls[3].
The minimum distance between cows, in this case, is 3,
which also is the largest among all possible ways.

Example 2:
Input:
n=5
k=3
stalls = [10 1 2 7 5]
Output:
4
Explanation:
The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows, in this case, is 4,
which also is the largest among all possible ways.

Constraints:
2 <= n <= 105
2 <= k <= n
0 <= stalls[i] <= 109
 */
public class Aggressive_Cows {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,5};
        int k = 3;
        System.out.println(solve(5, k, arr));
    }
    public static int solve(int n, int k, int[] stalls) {
        int ans = -1, l = 0, h = (int)1e9;
        Arrays.sort(stalls);
        while (l <= h) {
            int m = l + (h - l)/2;

            if (isPossible(stalls, k, m)) {
                ans = m;
                l = m + 1;
            } else h = m - 1;

        }

        return ans;
    }

    private static boolean isPossible(int[] stalls, int k, int m) {
        int prevCow = stalls[0];
        k--;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - prevCow >= m) {
                prevCow = stalls[i];
                k--;
                if (k == 0) return true;
            }
        }
        return false;
    }
}
