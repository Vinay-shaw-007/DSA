package Arrays;

public class Boolean_Matrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        booleanMatrix(matrix);
        print(matrix);

    }

    static void booleanMatrix(int matrix[][]) {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (boolean i: col)
            System.out.print(i+" ");
        System.out.println();
        System.out.println();
        for (boolean i: row)
            System.out.println(i+" ");

        System.out.println();
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    private static void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }


}
