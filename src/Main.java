// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] list = {1,2,3,5,6,4};
        for (Integer i: Solution.nextPermutation(6, list))
            System.out.print(i+" ");
    }

}
class Solution{
    static List<Integer> nextPermutation(int N, int[] arr){
        // code here

        List<Integer> list = new ArrayList<>();
        int idx = -1, last = N-1;

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] < arr[last]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            Arrays.sort(arr);
            for (int i: arr)
                list.add(i);
            return list;
        }

        int temp = arr[last];
        arr[last] = arr[idx];
        arr[idx] = temp;
        Arrays.sort(arr, idx+1, arr.length);
        for (int i: arr)
            list.add(i);
        return list;

    }
}