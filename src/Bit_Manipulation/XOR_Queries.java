package Bit_Manipulation;
/*
Problem Statement
Given an array of positive integers and a set of queries, where each query consists of a range [lefti, righti], find the XOR of all elements within that range for each query and return an array of the answers.

Example 1:
Input:

arr = [5, 8, 9, 11]

Queries = [[0,2],[1,3]]

Output:

[4, 10]

Explanation:

For query [0, 2], 5 ^ 8 ^ 9 = 4

For query [1, 3], 8 ^ 9 ^ 11 = 10

Example 2:
Input:

arr = [12, 23, 22, 11, 6]

Queries = [[0, 3], [2, 3]]

Output:

[6, 29]
 */
public class XOR_Queries {
    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 11};

        int[][] Queries = {{0,2},{1,3}};

        for (int i : xorQueries(arr, Queries))
            System.out.print(i+" ");
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];

        int n = arr.length;

        int[] xor = new int[n];

        xor[0] = arr[0];

        for (int i = 1; i < n; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0] == 0 ? 0 : xor[queries[i][0] - 1];
            int right = xor[queries[i][1]];
            ans[i] = left ^ right;
        }

        return ans;
    }
}
