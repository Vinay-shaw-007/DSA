package Arrays;

import java.util.Scanner;

public class PrintDiagonally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            int k = i;
            for (j = 0; j <= i; j++) {
                System.out.print(arr[j][k]+" ");
                if (k > 0) k--;
            }
        }
        i--; j--;
        for (int a = 1; a < n; a++) {
            int t = a;
            for (int b = j; b >= a; b--) {
                System.out.print(arr[t][b]+" ");
                if (t < j) t++;
            }
        }
        System.out.println();
        System.out.println("i = "+i+" j = "+j);

    }
}
