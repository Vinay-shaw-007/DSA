package Binary_Search;

import static Arrays.MultipleLeftRotationOfTheArray.printArray;

/*
Problem Statement
Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.

Example 1:
Input:
R = 3, C = 3
M = [[1, 3, 5],
     [2, 6, 9],
     [3, 6, 9]]

Output:

5

Explanation: Sorting matrix elements gives us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median.

Example 2:
Input:
R = 3, C = 1
M = [[1], [2], [3]]

Output:

2

Explanation: Sorting matrix elements gives us {1,2,3}. Hence, 2 is median.

Constraints:
1 <= R, C <= 400
1 <= matrix[i][j] <= 2000
 */
public class Median_in_a_row_wise_sorted_Matrix {
    public static void main(String[] args) {
        int R = 3, C = 3;
        int[][] M = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        System.out.println(median(M, R, C));
    }

    public static int median(int[][] matrix, int R, int C) {
        int ans = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int desired = (r * c) / 2;
        int l = Integer.MAX_VALUE, h = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            l = Math.min(l, matrix[i][0]);
            h = Math.max(h, matrix[i][c - 1]);
        }

        while (l <= h) {
            int mid = l + (h - l)/2;
            int count = 0;
            for (int i = 0; i < r; i++) {
                count += elements_less_than_equal_to_k(matrix[i], mid);
            }
            if (count > desired) {
                ans = mid;
                h = mid - 1;
            } else l = mid + 1;
        }


        return ans;
    }

    private static int elements_less_than_equal_to_k(int[] matrix, int k) {
        int l = 0, r = matrix.length - 1, ans = matrix.length;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (matrix[mid] > k) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }
}
