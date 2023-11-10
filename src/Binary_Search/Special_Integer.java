package Binary_Search;

/*
Problem Statement
Given an array of integers A[] of length n and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B. If the condition cannot be satisfied return -1.

Example 1:
Input:

n = 4, B = 8

A = [1, 2, 3, 4]

Output:

2

Explanation:

In the given input with an array [1, 2, 3, 4] and B = 8, we can choose K = 2, as no subarray of size 2 has a sum greater than 8 (e.g., [1, 2] or [2, 3] or[3, 4]). However, if we choose K = 3, the subarray [2, 3, 4] would have a sum of 9, which is greater than B. Therefore, the maximum valid K is 2.

Constraints:
1  <= n <= 105

1  <= Ai <= 109

1  <= B <= 109
 */
public class Special_Integer {
    public static void main(String[] args) {
        int B = 8;
        int[] A = {1, 2, 3, 4};
        System.out.println(specialInteger(A, B));
    }

    public static int specialInteger(int[] A, int B) {
        int ans = -1, n = A.length;

        int l = 0, r = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // This function will return true if no subArray sum of size mid is greater than B is present in the array.
            if (isPossible(A, B, n, mid)) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }

        return ans == 0 ? -1 : ans;
    }

    private static boolean isPossible(int[] arr, int B, int n, int subArraySize) {
        int sum = 0, i = 0;
        for (; i < subArraySize; i++) {
            sum += arr[i];
        }
        for (; i < n; i++) {
            if (sum > B) return false;
            sum -= arr[i - subArraySize];
            sum += arr[i];
        }
        return sum < B;
    }
}
