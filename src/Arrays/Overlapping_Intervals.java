package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Overlapping_Intervals {
    public static void main(String[] args) {
        int[][] interval = {
                { 2, 3 },
                { 1, 5 },
                { 2, 4 },
                { 7, 8 }
        };
        // int[][] interval = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
        int[][] interval1 = overlappedInterval(interval);
        for (int i = 0; i < interval1.length; i++) {
            for (int j = 0; j < interval1[i].length; j++) {
                System.out.print(interval1[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] overlappedInterval(int[][] interval) {
        /*
         * commented code is useful when you don't care about the remaining spaces in
         * the answer array
         * but in my case online platform doesn't excepting the remaining spaces so i
         * have to use list and
         * then convert it into array.
         * EX ->
         * with array
         * 1, 5
         * 7, 8
         * 0, 0
         * 0, 0
         * with Arraylist
         * 1, 5
         * 7, 8
         * ans this format of answer is excepting in the platform so that i have to use
         * arraylist.
         */

        // int row = interval.length;
        // int column = interval[0].length;
        // int[][] ans = new int[row][column];
        List<List<Integer>> list = new ArrayList<>();

        int i = 0;
        Arrays.sort(interval, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                int result = Integer.compare(o1[0], o2[0]);
                if (result == 0) {
                    result = Integer.compare(o1[1], o2[1]);
                }
                return result;
            }

        });

        System.out.println("After Sorting");
        for (int k = 0; k < interval.length; k++) {
            for (int j = 0; j < interval[k].length; j++) {
                System.out.print(interval[k][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Answer");
        list.add(Arrays.asList(interval[i][0], interval[i][1]));
        // ans[i][0] = interval[i][0];
        // ans[i][1] = interval[i][1];
        i++;

        for (int j = 1; j < interval.length; j++) {
            // int start = interval[j][0];
            // int end = interval[j][1];

            int start1 = interval[j][0];
            int end1 = interval[j][1];

            int k = i - 1;

            // int prevEnd = ans[k][1];

            // if (prevEnd >= start) {
            // ans[k][1] = Math.max(end, prevEnd);
            // } else {
            // ans[i][0] = start;
            // ans[i][1] = end;
            // i++;
            // }

            int prevEnd1 = list.get(k).get(1);
            System.out.println("Previous End = " + prevEnd1);

            if (prevEnd1 >= start1) {
                list.set(k, Arrays.asList(list.get(k).get(0), Math.max(end1, prevEnd1)));
            } else {
                list.add(Arrays.asList(start1, end1));
                i++;
            }
        }
        int rows = list.size();
        int columns = list.get(0).size();

        int[][] array2D = new int[rows][columns];

        for (int i1 = 0; i1 < rows; i1++) {
            for (int j = 0; j < columns; j++) {
                array2D[i1][j] = list.get(i1).get(j);
            }
        }
        return array2D;
    }
}
