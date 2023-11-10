package Advanced_Sorting_Algorithm_and_Greedy_Problem;

import static Arrays.MultipleLeftRotationOfTheArray.printArray;

/*
Problem Statement
Given an array arr[], its starting position l and its ending position r. Sort the array using merge sort algorithm.

Your task is to complete the function merge() which takes arr[], l, m, r as its input parameters and modifies arr[] in-place such that it is sorted from position l to position r, and function mergeSort() which uses merge() to sort the array in ascending order using merge sort algorithm.

Example 1:
Input:

N = 5

arr[] = {4, 2, 5, 1, 3}

Output:

{1, 2, 3, 4, 5}

Example 2:
Input:

N = 2

arr[] = {2, 1}

Output:

{1, 2}

Constraints:
1 <= N <= 105
1 <= arr[i] <= 105
 */
public class Merge_Sort {
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {4, 2, 5, 1, 3};
        mergeSort(arr, 0, N - 1);
        printArray(arr);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int leftArraySize = m - l;
        int rightArraySize = r - m + 1;
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i = l; i < m; i++) {
            leftArray[i - l] = arr[i];
        }

        for (int i = m; i <= r; i++) {
            rightArray[i - m] = arr[i];
        }

        int i = 0, j = 0, k = l;

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] < rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < leftArraySize) {
            arr[k++] = leftArray[i++];
        }

        while (j < rightArraySize) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {

        if (l < r) {
            int mid = (l + r+1) / 2;
            mergeSort(arr, l, mid-1);
            mergeSort(arr, mid, r);
            merge(arr, l, mid, r);
        }

    }
}
