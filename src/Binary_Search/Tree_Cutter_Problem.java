package Binary_Search;
/*
Problem Statement
Given an array A[] of N integers, where A[i] denotes the height of ith tree.
Geek needs to cut down M meters of wood. He has a woodcutting machine that works as follows:  Set the blade at a height parameter H, and the machine cuts off all trees having a height greater than H. The trees having less than height H remains intact.
Since Geek is an environmentalist, he doesn't want to cut woods more than necessary, so he set the height H as high as possible.
Find the maximum height H of the blade that still allows to cutoff at least M meters of wood.

Example 1:
Input:
A[] = {20, 15, 10, 17}
M = 7

Output:

15

Explanation:

Set the height parameter to 15, then Geek can chop:
  1.5 metres from first tree
  2. 0 metres from second tree
  3. 0 metres from third tree
  4. 2 metres from fourth tree
  So in total Geek chopped 5 + 2 = 7 metres of wood.

Example 2:
Input:

A[] = {4, 42, 40, 26, 46}
M = 20

Output:
36

Constraints:
1 <= N <= 106
1 <= A[i] <=106
1 <= M <=2 * 106
 */
public class Tree_Cutter_Problem {
    public static void main(String[] args) {
        int A[] = {20, 15, 10, 17};
        int M = 7;
        System.out.println(maxHeight(4, A, M));
    }
    public static int maxHeight(int N, int[] A, int M) {
        int ans = -1;
        int l = 0, h = (int)1e9;
        while (l <= h) {
            int m = l+(h-l)/2;
            int woodCount = getWoodCountCut(A, m);
            if (woodCount == M) return m;
            if (woodCount > M) {
                ans = m;
                l = m+1;
            } else h = m - 1;
        }
        return ans;
    }

    private static int getWoodCountCut(int[] a, int m) {

        int count = 0;
        for (int e: a) {
            if (e > m) {
                count += e - m;
            }
        }
        return count;
    }
}
