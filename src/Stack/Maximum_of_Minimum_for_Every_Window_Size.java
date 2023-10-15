package Stack;

import java.util.ArrayDeque;

/*
Problem Statement
Given an integer array. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to the size of the Array.

Example 1:
Input:
N = 7
arr[] = [10,20,30,50,10,70,30]

Output: [70, 30, 20, 10, 10, 10, 10]

Example 2:
Input:
N = 3
arr[] = [1, 2, 3]

Output: [3, 2, 1]
 */
public class Maximum_of_Minimum_for_Every_Window_Size {
    public static void main(String[] args) {
        int N = 7;
        int[] arr = {10,20,30,50,10,70,30};
        for (int i : maxOfMin(arr, N))
            System.out.print(i+" ");
    }
    public static int[] maxOfMin(int[] arr, int n) {
        int[] ans = new int[n];
        int[] ps = getPreviousSmaller(arr, n);
        int[] ns = getNextSmaller(arr, n);

        System.out.println("left = ");
        for (int i : ps)
            System.out.print(i+ " ");

        System.out.println();
        System.out.println("right = ");
        for (int i : ns)
            System.out.print(i+ " ");
        System.out.println();

        for (int i = 0; i < n; i++) {
            int wl = ns[i] - ps[i] - 1;
            ans[wl - 1] = Math.max(ans[wl-1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
    }

    private static int[] getNextSmaller(int[] arr, int n) {
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

    private static int[] getPreviousSmaller(int[] arr, int n) {
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
