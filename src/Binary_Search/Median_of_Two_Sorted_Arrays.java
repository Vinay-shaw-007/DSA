package Binary_Search;
/*
Problem Statement
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input:

nums1 = [1,3], nums2 = [2]

Output:

2.00000

Explanation:

merged array = [1,2,3] and median is 2.

Example 2:
Input:

nums1 = [1,2], nums2 = [3,4]

Output:

2.50000

Explanation:

The merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {3,4,5};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int left = (n+1)/2;

        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int l = 0, r = n1;
        while (l <= r) {
            int m1 = l + (r - l)/2;
            int m2 = left - m1;

            int l1 = (m1 - 1 >= 0) ? nums1[m1 - 1] : Integer.MIN_VALUE;
            int l2 = (m2 - 1 >= 0) ? nums2[m2 - 1] : Integer.MIN_VALUE;

            int r1 = (m1 < n1) ? nums1[m1] : Integer.MAX_VALUE;
            int r2 = (m2 < n2) ? nums2[m2] : Integer.MAX_VALUE;

            if (l1 > r2) {
                r = m1 - 1;
            } else if (l2 > r1) {
                l = m1 + 1;
            } else {
                if ((n & 1) != 0) {
                    return Math.max(l1,l2);
                } else {
                    return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
            }
        }
        return 0;
    }
}
