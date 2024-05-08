package Arrays;

import static Arrays.Inplace_rotate_matrix_90_degree.display2DArray;

public class Set_Matrix_Zeros {
    public static void main(String[] args) {
//        int[][] input = {
//                {7, 19, 3},
//                {4, 21, 0}
//        };

        int[][] input = {
                {1, 0},
                {2, 7},
                {3, 0},
                {4, 8}
        };
        setZerosOptimized(input);
        System.out.println("Final answer......");
        display2DArray(input);
    }

    public static void setZeros(int[][] matrix) {
        // Write your code here.
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] != 0) continue;

                // Set its row to 0.
                for (int k = 0; k < col; k++) {
                    if (matrix[i][k] != 0)
                        matrix[i][k] = -1;
                }

                // Set its col to 0.
                for (int k = 0; k < row; k++) {
                    if (matrix[k][j] != 0)
                        matrix[k][j] = -1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }

    public static void setZerosOptimized(int[][] matrix) {
        // Write your code here.
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] zeroRow = new boolean[row];
        boolean[] zeroCol = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (zeroRow[i] || zeroCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
