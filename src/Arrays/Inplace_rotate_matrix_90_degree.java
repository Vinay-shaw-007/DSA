package Arrays;


public class Inplace_rotate_matrix_90_degree {

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        display2DArray(input);
        System.out.println("After Rotation");
        inplaceRotate(input, input.length);
        display2DArray(input);
    }

    public static void display2DArray(int[][] input) {
        for (int[] i : input) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void inplaceRotate(int[][] arr, int n) {
        // Write your code here.
        // Steps to in place rotation
        // Step 1 -> 1st transpose the given array....
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // Step 2 -> swap top and bottom element iteratively.
        int k = n - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[k][j];
                arr[k][j] = temp;
            }
            k--;
        }
    }
}
