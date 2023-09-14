package Arrays;

public class Minimum_Sum_SubArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6, 7, 2};
        System.out.println(minimumSum(a, 7));

    }

    private static int minimumSum(int[] a, int k) {
        int j = 0, i = 0, n = a.length, minSum = 0, minLength = Integer.MAX_VALUE;

        while (j < n) {
            minSum += a[j];
            while (minSum >= k) {
                minLength = Math.min((j - i + 1), minLength);
                minSum -= a[i];
                i++;
            }
            j++;
        }
        return minLength;
    }


}
