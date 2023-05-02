package Arrays;

import java.util.Scanner;

public class SetMatrixZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        setZeroes(arr);
        displayMatrix(arr);
    }

    private static void displayMatrix(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void setZeroes(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        boolean x = false, y = false;
        //step 1
        for (int i = 0; i < col; i++) {
            if (arr[0][i] == 0) {
                x = true;
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            if (arr[i][0] == 0) {
                y = true;
                break;
            }
        }
        //step 2
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (arr[i][j] == 0) {

                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        //step 3
        for (int i = 1; i < col; i++) {
            if (arr[0][i] == 0) {
                for (int j = 1; j < row; j++) {
                    arr[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            if (arr[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        //step 4
        if (x) {
            for (int i = 0; i < col; i++) {
                arr[0][i] = 0;
            }
        }
        if (y) {
            for (int i = 0; i < row; i++) {
                arr[i][0] = 0;
            }
        }
    }
}
