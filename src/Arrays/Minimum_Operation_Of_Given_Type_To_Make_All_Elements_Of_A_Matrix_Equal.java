package Arrays;

import java.util.Arrays;

/*
Problem Statement
Given an integer K and a matrix of N rows and M columns, the task is to find the minimum number of operations required to make all the elements of the matrix equal.
In a single operation, K can be added to or subtracted from any element of the matrix.

Example 1:
Input:

A = [[0, 2, 8],

     [8, 2, 0],

     [0, 2, 8]]

K = 2

Output:

12
 */
public class Minimum_Operation_Of_Given_Type_To_Make_All_Elements_Of_A_Matrix_Equal {
    public static void main(String[] args) {
        int[][] A = {
                {0, 2, 8},
                {8, 2, 0},
                {0, 2, 8}
        };
        int K = 2;
        System.out.println(minOperations(3, 3, 2, A));
    }

    public static int minOperations(int n, int m, int k, int[][] A) {
        int count = 0, total = n * m, median;

        int[] b = new int[total];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i * m + j] = A[i][j];
            }
        }

        Arrays.sort(b);

        median = b[total / 2];

        for (int i = 0; i < total; i++) {
            if (b[i] % median != 0) return -1;
            count += Math.abs(b[i] - median) / k;
        }

        return count;
    }
}
