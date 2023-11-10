package Advanced_Sorting_Algorithm_and_Greedy_Problem;

import static Arrays.MultipleLeftRotationOfTheArray.printArray;

/*

 */
public class Quick_Sort {
    public static void main(String[] args) {
        int N = 5;
        int arr[] = {4, 2, 5, 1, 3};
        quickSort(arr, 0, N - 1);
        printArray(arr);
    }

    public static void quickSort(int arr[], int low, int high) {
        //You can code here
        if (low < high) {
            int pivot = partition(arr, low, high);
            System.out.println("low = "+low+", high = "+high+", pivot index = "+pivot);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }


    public static int partition(int arr[], int low, int high) {
        //You can code here
        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (i <= high && arr[i] <= pivot) i++;
            while (j >= low && arr[j] > pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
