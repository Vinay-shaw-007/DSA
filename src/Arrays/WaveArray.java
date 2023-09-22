package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        System.out.println(wave(a));
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        //You Can Code Here
        Collections.sort(A);
        
        for (int i = 1; i < A.size(); i+=2) {
            swap(A, i, i - 1);
        }

        return A;
    }
    private static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
