package Arrays;

import java.util.Arrays;

public class Find_Maximum_Equal_sum_of_Three_Stacks {
    public static void main(String[] args) {
        int[] s1 = { 4, 2, 3 };
        int[] s2 = { 1, 1, 2, 3 };
        int[] s3 = { 1, 4 };
        System.out.println(maxEqualSum(s1.length, s2.length, s3.length, s1, s2, s3));
    }

    private static int maxEqualSum(int n1, int n2, int n3, int[] s1, int[] s2, int[] s3) {
        int t1 = Arrays.stream(s1).sum();
        int t2 = Arrays.stream(s2).sum();
        int t3 = Arrays.stream(s3).sum();

        int i = 0, j = 0, k = 0;
        while (i < n1 || j < n2 || k < n3) {
            int max = Math.max(t1, Math.max(t2, t3));

            if (t1 == max && t2 == max && t3 == max)
                return max;

            else if (t1 == max && i < n1)
                t1 -= s1[i++];

            else if (t2 == max && j < n2)
                t2 -= s2[j++];

            else if (t3 == max && k < n3)
                t3 -= s3[k++];
        }

        return 0;
    }

}
