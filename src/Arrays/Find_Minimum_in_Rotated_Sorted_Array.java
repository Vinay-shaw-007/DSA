package Arrays;
public class Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        // int[] nums = {5,1,2,3,4};
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int n = nums.length;

        int i = 0, j = n - 1;
        while(i <= j) {
            System.out.println("i = "+i+", j = "+j);

            int mid = (i + j)/2;

            if (nums[i] <= nums[mid]) {
                min = Math.min(min, nums[i]);
                i = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                j = mid - 1;
            }
           
        }
           
        return min;
    }
}
