package Heaps_and_Hashing;


import java.util.Arrays;

public class Minimum_Difference_among_K {

    public static void main(String[] args) {
        long[] a = {10, 100, 300, 200, 1000, 20, 30};
        int n = 7, k = 3;
        System.out.println(minDiff(a, n, k));
    }

    private static long minDiff(long[] a, int n, int k) {
        Arrays.sort(a);
        return Math.abs(a[k-1] - a[0]);
    }
}
