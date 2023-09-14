package Arrays;

public class MultipleLeftRotationOfTheArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,3};
        for (int[] a1: multipleLeftRotation(a,b)) {
            printArray(a1);
            System.out.println();
        }
    }

    private static void printArray(int[] a) {
        for (int i: a)
            System.out.print(i+ " ");
    }

    public static int[][] multipleLeftRotation(int[] A, int[] B) {
        //You Can Code Here
        int n = A.length, m = B.length;

        int[][] ans = new int[m][n];

        int[] temp = new int[n * 2];

        for (int i = 0; i < n * 2; i++)
            temp[i] = A[i % n];

        for (int i = 0; i < m; i++)
            ans[i] = rotateArray(B[i], temp, n);

        return ans;
    }

    private static int[] rotateArray(int i, int[] temp, int n) {
        int[] ans = new int[n];

        for (int j = 0; j < n; j++)
            ans[j] = temp[i%n + j];

        return ans;
    }
}
