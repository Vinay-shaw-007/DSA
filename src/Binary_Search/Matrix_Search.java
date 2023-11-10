package Binary_Search;
/*
Problem Statement
Write an efficient algorithm to search for a given integer B within a matrix A of size N x M, where the integers in each row are sorted from left to right, and the first integer of each row is greater than or equal to the last integer of the previous row. Return 1 if B is found, otherwise, return 0. The algorithm should have a time complexity of log(n) or faster

Example 1:
Input:

A = [[2, 4, 9, 11]

[13, 17, 19, 111]

[222, 224, 777, 888]]

B = 9

Output:

1

Explanation:

9 is present in the Matrix at A[0][2].

Example 2:
Input:

A = [[1, 2, 3]

[7, 9, 12]

[22, 23, 24]]

B = 5

Output:

0

Constraints:
1 <= N, M <= 1000

1 <= A[i][j], B <= 106
 */
public class Matrix_Search {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},

                    {7, 9, 12},

                    {22, 23, 24}};

        int B = 24;
        System.out.println(searchMatrix(A,B));
    }
    public static int searchMatrix(int[][] A, int B) {
        int r = A.length;
        int c = A[0].length;

        int l = 0, h = r * c - 1;

        while (l <= h) {
            int mid = l + (h - l)/2;

            int assumedRow = mid / c;
            int assumedColumn = mid % c;

            if (A[assumedRow][assumedColumn] == B) return 1;
            if (A[assumedRow][assumedColumn] > B) h = mid - 1;
            else l = mid + 1;
        }

        return 0;
    }
}
