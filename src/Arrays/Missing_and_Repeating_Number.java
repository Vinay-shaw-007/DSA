package Arrays;

import java.util.*;

public class Missing_and_Repeating_Number {
    public static void main(String[] args) {
        int[] a = {4, 2, 3, 2};
        System.out.println(findNumbers(a));
    }
    public static Vector<Integer> findNumbers(int[] a)
    {
        //You can code here

        int duplicate = -1, n = a.length, sum, totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += Math.abs(a[i]);
            if (a[Math.abs(a[i]) - 1] > 0) {
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
            } else
                duplicate = Math.abs(a[i]);
        }
        sum = totalSum - duplicate;
        Vector<Integer> v = new Vector<>();
        v.add((n*(n + 1) / 2) - sum);
        v.add(duplicate);
        return v;

    }
}
