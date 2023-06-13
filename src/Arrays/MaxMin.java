package Arrays;

import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < 5; i++) {
            if (arr[i] < min) min = arr[i];
            else if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Max = "+max+", Min = "+min);
    }
}
