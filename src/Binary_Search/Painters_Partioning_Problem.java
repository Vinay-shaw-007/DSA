package Binary_Search;
/*
Problem Statement
Given n paint-boards, of length {a1, a2, …., an}, and k painters, find the minimum time to paint all the boards,
such that any painter will paint only contiguous sections of paint boards.
It may be assumed that each painter takes 1 unit of time to paint 1 unit of board.

Example 1:
Input:

arr = [55, 8, 33, 12, 48, 9, 1]

k = 2

Output:

96

Explanation:

96 is the minimum time to paint all the boards.

Example 2:
Input:

arr = [72, 82, 31, 9, 99]

k = 3

Output:

113

Constraints:
1 <= |a|,k <= 100000

1 <= a[i] <= 10000
 */
public class Painters_Partioning_Problem {
    public static void main(String[] args) {
//        int[] arr = {55, 8, 33, 12, 48, 9, 1};
//        int k = 2;
        int[] arr = {10,10,10,10};
        int k = 2;
        System.out.println(getMinimumTime(arr, arr.length, k));
    }
    public static int getMinimumTime(int arr[], int n, int k) {
        int ans = 0, l = 0, r = 0;
        for (int i: arr) {
            l = Math.max(i,l);
            r += i;
        }

        while (l <= r) {
            int mid = l + (r - l)/2;

            if (isPainterAbleToDoneTheJob(arr, n, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }

    private static boolean isPainterAbleToDoneTheJob(int[] arr, int n, int painter, int maximumTime) {
        int sum = arr[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (sum+arr[i] <= maximumTime) sum += arr[i];
            else {
                count++;
                sum = arr[i];
            }
        }
        return count <= painter;
    }
}
