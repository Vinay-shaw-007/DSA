package Arrays;

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    private static int trap(int[] arr) {
        int trappedWater = 0;
        int leftBar = arr[0], rightBar = arr[arr.length - 1];
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] > leftBar) leftBar = arr[i];
            if (arr[j] > rightBar) rightBar = arr[j];

            if (leftBar <= rightBar) {
                trappedWater += leftBar - arr[i];
                i++;
            } else {
                trappedWater += rightBar - arr[j];
                j--;
            }
        }
        return trappedWater;
    }
}