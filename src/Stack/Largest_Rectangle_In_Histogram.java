package Stack;

import java.util.ArrayDeque;

/*
Problem Statement
Given an array of integers of length n , heights where every element of the array represents histogram's bar height and the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input:

heights = [2,1,5,6,2,3]

Output:

10

Explanation:

The above is a histogram where width of each bar is 1.


The largest rectangle is shown in the red area, which has an area = 10 units.


Example 2:
Input:

heights = [1 , 2 , 3 , 4 , 5]

Output:

9

Explanation: The largest rectangle is formed by the bars with height 3, 4 and 5 , each will give height 3 to the rectangle. Thus, area of the rectangle is 9.
 */
public class Largest_Rectangle_In_Histogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int[] ps = getPreviousSmaller(heights);
        int[] ns = getNextSmaller(heights);
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int currArea = (ns[i] - ps[i] - 1) * heights[i];
            maxArea = Math.max(maxArea,currArea);
        }
        return maxArea;
    }

    private static int[] getPreviousSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();

            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();

            st.push(i);
        }

        return ans;
    }

    private static int[] getNextSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();

            if (st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();

            st.push(i);
        }

        return ans;
    }
}
