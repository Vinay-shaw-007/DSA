package Arrays;
/*
Given an array arr[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array. Your task is to count the frequency of all numbers from 1 to N. Make in-place changes in arr[], such that arr[i] = frequency(i). Assume 1-based indexing.
Note: The elements greater than N in the array can be ignored for counting and do modify the array in-place.

Example 1:

Input:
N = 5
arr[] = {2, 3, 2, 3, 5}
P = 5
Output:
0 2 2 0 1
Explanation:
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.
Example 2:

Input:
N = 4
arr[] = {3,3,3,3}
P = 3
Output:
0 0 4 0
Explanation:
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 0 times.
3 occurring 4 times.
4 occurring 0 times.
Example 3:

Input:
N = 2
arr[] = {8,9}
P = 9
Output:
0 0
Explanation:
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 0 times.
Since here P=9, but there are no 9th Index present so can't count the value.
Your Task:
You don't need to read input or print anything. Complete the function frequencyCount() that takes the array arr, and integers n, and p as input parameters and modify the array in-place to denote the frequency count of each element from 1 to N.

Expected time complexity: O(N)
Expected auxiliay space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ P ≤ 4*104
1 <= arr[i] <= P
 */
public class Frequencies_of_Limited_Range_Array_Elements {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3};
        frequencyCount(arr, 4, 3);

//        int[] arr = {1,2,3,3,4,4,4,5,6,7};
//        frequencyCount(arr, 10, 7);
        System.out.println("Answer");
        print(arr);
    }
    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        P++; // This is done to handle the edge case, if one or more element is equal to P in that case we need to increment the P value.
        for (int i = 0; i < N; i++) {

            int targetIdx = arr[i]%P - 1;

            if (targetIdx>=0 & targetIdx < N) { // This implies that the target index should be present inside the array
                arr[targetIdx] += P;// Here, we're just increasing the frequency.
            }
            print(arr);
        }

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] / P;
        }
    }
    private static void print(int[] arr) {
        for (int i : arr)
            System.out.print(i+" ");
        System.out.println();
    }
}
