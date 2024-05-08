package Arrays;

import java.util.ArrayList;

public class Sum_Of_Zeroes {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(0);
        row1.add(1);
        row1.add(0);
        row1.add(1);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(0);
        row2.add(1);
        row2.add(0);

        list.add(row1);
        list.add(row2);

        System.out.println(coverageOfMatrix(list));
    }

    public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        Integer ans = 0;
        int row = mat.size();
        int col = mat.get(0).size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat.get(i).get(j) == 0) {
                    ans += findCoverage(i, j, mat);
                }
            }
        }
        return ans;
    }

    private static Integer findCoverage(int i, int j, ArrayList<ArrayList<Integer>> mat) {
        Integer coverageSum = 0;
        //top
        if (isSafe(i-1, j, mat)) {
            coverageSum++;
        }
        //bottom
        if (isSafe(i+1, j, mat)) {
            coverageSum++;
        }
        //left
        if (isSafe(i, j-1, mat)) {
            coverageSum++;
        }
        //right
        if (isSafe(i, j+1, mat)) {
            coverageSum++;
        }

        return coverageSum;
    }

    private static boolean isSafe(int i, int j, ArrayList<ArrayList<Integer>> mat) {
        int row = mat.size();
        int col = mat.get(0).size();
        return i >= 0 && i < row && j >= 0 && j < col && (mat.get(i).get(j) == 1);
    }
}
