package Arrays;

import java.util.*;

public class Maximum_Unsorted_SubArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(subUnsort(list));
    }

    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        // You can code here
        ArrayList<Integer> ans = new ArrayList<>();

        int start = -1, end = -1, n = A.size();
        int i = 0, j = n - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (i < n - 1) {
            if (A.get(i) > A.get(i + 1)) {
                start = i;
                break;
            }
            i++;
        }

        while (j > 0) {
            if (A.get(j) < A.get(j - 1)) {
                end = j;
                break;
            }
            j--;
        }
        if (start == -1 && end == -1) {
            ans.add(-1);
            return ans;
        }

        for (int k = start; k <= end; k++) {
            if (A.get(k) < min) min = A.get(k);
            if (A.get(k) > max) max = A.get(k);
        }

//        System.out.println("start = "+start+", end = "+end);
//        System.out.println("Min = "+min+", max = "+max);


        for (int k = 0; k < start; k++) {
            if (A.get(k) > min) {
                start = k;
//                min = A.get(k);
            }
        }
        for (int k = end; k < n; k++) {
            if (A.get(k) < max) {
                end = k;
//                max = A.get(k);
            }
        }
//        System.out.println("After checking");
//        System.out.println("start = "+start+", end = "+end);
//        System.out.println("Min = "+min+", max = "+max);


        ans.add(start);
        ans.add(end);


        return ans;
    }

}
