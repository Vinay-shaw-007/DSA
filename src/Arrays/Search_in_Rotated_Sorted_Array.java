package Arrays;

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        // int target = 0;
        // int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        int[] nums = {5,1,3};
        System.out.println(searchTarget(nums, target));
    }

    private static int searchTarget(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j)/2;
            if (nums[mid] == target) return mid;

            if (nums[i] <= nums[mid]) {
                if (target >= nums[i] && target < nums[mid]) {
                    j = j - 1;
                } else {
                    i = i + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[j]) {
                    i = i + 1;
                } else {
                    j = j + 1;
                }
            }
        }
        return -1;
    }
}
