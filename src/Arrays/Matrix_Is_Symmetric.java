package Arrays;

public class Matrix_Is_Symmetric {
    public static void main(String[] args) {
        int[][] input = {
                {1,2,3},
                {2,4,5},
                {3,5,8}
        };
        System.out.println(isMatrixSymmetric(input));
    }

    public static boolean isMatrixSymmetric(int[][] matrix) {
        // Write your code here.
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
