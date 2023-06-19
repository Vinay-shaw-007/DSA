package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Repeat_and_Missing {
    public static void main(String[] args) {
        // int[] arr = {3, 2, 1, 5, 3};
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(1);
        A.add(5);
        A.add(2);
        System.out.println(repeatedNumber(A));
    }
    public static ArrayList<Integer> repeatedNumber(final List<Integer> list){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int n = list.size(), sum = 0;
        int totalSum = n*(n+1)/2;

        for (Integer integer : list) {
            sum += integer;
        }

        for (Integer integer : list) {
            if (!set.contains(integer)) {
                set.add(integer);
            } else {
                ans.add(integer);
                sum -= integer;
                ans.add(Math.abs(totalSum - sum));
                break;
            }
        }

        return ans;
    }
}