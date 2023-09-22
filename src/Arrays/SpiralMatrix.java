package Arrays;

import static Arrays.MultipleLeftRotationOfTheArray.printArray;

public class SpiralMatrix {
    public static void main(String[] args) {

        for (int[] i:spiralMatrix(5)) {
            printArray(i);
            System.out.println();
        }
    }

    private static int[][] spiralMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0, left = 0;
        int bottom = n-1, right = n-1, k = 1;
        while (left<=right && top<=bottom) {
            //right
            for (int i = left; i <= right; i++) {
                ans[top][i] = k++;
            }
            top++;
            //bottom
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = k++;
            }
            right--;
            //left
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = k++;
            }
            bottom--;
            //top
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = k++;
            }
            left++;
        }
        return ans;
    }
}
