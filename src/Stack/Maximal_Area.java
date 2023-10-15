package Stack;


import java.util.ArrayDeque;

/*
Problem Statement
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:
Input:

[[1, 1, 0, 1]
[1, 1, 0, 0]
[1, 1, 0, 1]
[1, 1, 1, 1]]

Output:

8

Example 2:
Input:

[[1, 1, 0]
[1, 1, 0]]

Output:

4
 */
public class Maximal_Area {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '1', '0', '1'},
                {'1', '1', '0', '0'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int col = matrix[0].length;
        int[] ans = new int[col];
        int maxArea = 0;

        for (char[] chars : matrix) {
            for (int j = 0; j < col; j++) {
                if (chars[j] == '1') ans[j] = ans[j] + 1;
                else ans[j] = 0;
            }
            int currArea = maxArea(ans);
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }

    private static int maxArea(int[] arr) {
        int[] ps = previousSmaller(arr);
        int[] ns = nextSmaller(arr);
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int currArea = (ns[i] - ps[i] - 1) * arr[i];
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    private static int[] nextSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();

            if (st.isEmpty()) ans[i] = arr.length;
            else ans[i] = st.peek();

            st.push(i);

        }
        return ans;
    }

    private static int[] previousSmaller(int[] arr) {
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
}
