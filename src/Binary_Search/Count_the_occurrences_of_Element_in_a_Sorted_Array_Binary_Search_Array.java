package Binary_Search;
/*
Problem Statement
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:
Input:

N = 7, X = 2

Arr[] = {1, 1, 2, 2, 2, 2, 3}

Output: 4

Explanation: 2 occurs 4 times in the given array.

Example 2:
Input:

N = 7, X = 4

Arr[] = {1, 1, 2, 2, 2, 2, 3}

Output:

0

Explanation:

4 is not present in the given array.
 */
public class Count_the_occurrences_of_Element_in_a_Sorted_Array_Binary_Search_Array {
    public static void main(String[] args) {
        int N = 7, X = 2;

        int arr[] = {1, 1, 2, 2, 2, 2, 3};

        System.out.println(count(arr, N, X));
    }
    public static int count(int[] arr, int n, int k) {
        int lowerBound = lowerBound(arr, n, k);
        int upperBound = upperBound(arr, n, k);
        if (lowerBound == -1) return 0;
        return upperBound - lowerBound + 1;
    }

    private static int lowerBound(int[] arr, int n, int k) {
        int l = 0, r = n - 1, ans = -1;

        while (l <= r) {
            int mid = l + (r - l)/2;
            if (k == arr[mid]) {
                ans = mid;
                r = mid - 1;
            } else if (k < arr[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return ans;
    }

    private static int upperBound(int[] arr, int n, int k) {
        int l = 0, r = n - 1, ans = -1;

        while (l <= r) {
            int mid = l + (r - l)/2;
            if (k == arr[mid]) {
                ans = mid;
                l = mid + 1;
            } else if (k < arr[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return ans;
    }
}
