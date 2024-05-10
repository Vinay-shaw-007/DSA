package Arrays;

public class Print_Spiral {
    public static void main(String[] args) {
//        int[][] input = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//        };

        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        spiralPrint(input);
    }

    public static void spiralPrint(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return; // Empty matrix, nothing to print
        int col = matrix[0].length;

        int startRow = 0, endRow = row - 1;
        int startCol = 0, endCol = col - 1;
        int count = 1, var = row * col;

        while (count <= var) {


            // left to right
            for (int i = startRow; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
                count++;
            }
            startRow++;


            // top to bottom
            for (int i = startRow; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
                count++;

            }
            endCol--;


            // right to left
            for (int i = endCol; i >= startCol; i--) {
                System.out.print(matrix[endRow][i] + " ");
                count++;

            }
            endRow--;


            //bottom to top
            for (int i = endRow; i >= startRow; i--) {
                System.out.print(matrix[i][startCol] + " ");
                count++;

            }
            startCol++;
        }
    }

}
