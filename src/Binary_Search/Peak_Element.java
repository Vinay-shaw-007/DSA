package Binary_Search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
Problem Statement
A peak element is an element that is not smaller than its neighbors.

Given an array A, find a peak element, and return its index. If the array contains multiple peaks, return the smallest index of the peak element.

For corner elements, we need to consider only one neighbor.



Example 1:
Input:

A = [4, 5, 6, 7, 8, 1]

Output:

4

Explanation:

In this problem, we're tasked with finding a "peak" element in an array, which is an element greater than or equal to its neighbors. We iterate through the array, checking each element's relationship with its neighbors, including corner elements with only one neighbor. In the sample input [4, 5, 6, 7, 8, 1], the peak element is 8, and its index is 4. This is because it's greater than its neighbors, and we return the index of any peak found, which, in this case, is 4.

Example 2:
Input:

A = [1, 2, 3]

Output:

2

Constraints:
1 <= A.size() <= 100

-231 <= A[i] <= 231 - 1
 */
public class Peak_Element {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] A = {4, 5, 6, 7, 8, 9};
        for (int i:
             A) {
            list.add(i);
        }
        System.out.println(findPeak(list));
    }
    public static int findPeak(List<Integer> A) {

        int n = A.size(), l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + (r - l)/2;

            if ((mid == 0 || A.get(mid-1) < A.get(mid)) && (mid == n - 1 || A.get(mid) > A.get(mid+1))) return mid;

            if (A.get(mid) > A.get(mid+1)) r = mid - 1;
            else l = mid + 1;
        }

        return 0;
    }
}
