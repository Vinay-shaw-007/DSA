package Arrays;

import static Arrays.MultipleLeftRotationOfTheArray.printArray;
import static Backtracking.PermutationOfAnArray.swap;

public class Smallest_Positive_missing_number {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 4, 2};
        int[] arr = {-0, 1, -2, -3, -4, 5, -6, -7, 8, -9, 10, -11};
//        int[] arr = {3, 4, -1, 1};
        System.out.println("Answer = " + missingNumber(arr, 12));
    }

    public static int missingNumber(int arr[], int size) {
        // Your code here
        int last = size - 1;
        for (int i = 0; i < size; i++) {
//            System.out.println("i = "+i+" last = "+last);
            while (last >= 0 && arr[last] <= 0) {
                last--;
            }
            if (arr[i] <= 0 && i < last) {
                System.out.println("i = "+i+" last = "+last);
                int temp = arr[i];
                arr[i] = arr[last];
                arr[last] = temp;
            }
        }
        printArray(arr);
        System.out.println();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) return j + 1;
        }
        return arr.length + 1;
    }

//    public static int missingNumber(int arr[], int size) {
//        // Your code here
//        int i = 0;
//        while (i < size) {
////            System.out.println("i = " + i +", arr[i] = "+arr[i]+", arr[arr[i] - 1] = "+arr[arr[i] - 1]);
//            if (arr[i] >= 1 && arr[i] != arr[arr[i] - 1]) {
//                int temp = arr[arr[i] - 1];
//                arr[arr[i] - 1] = arr[i];
//                arr[i] = temp;
//            } else
//                i++;
//        }
//        printArray(arr);
//        System.out.println();
//        for (int j = 0; j < arr.length; j++) {
//            if (arr[j] != j + 1) return j+1;
//        }
//        return arr.length+1;
//    }
}
