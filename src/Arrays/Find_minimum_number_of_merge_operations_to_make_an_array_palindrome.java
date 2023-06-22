package Arrays;

public class Find_minimum_number_of_merge_operations_to_make_an_array_palindrome {
    public static void main(String[] args) {
        int[] nums = { 1, 4, 5, 2 };
        System.out.println(findMergeOperations(nums));
    }

    private static int findMergeOperations(int[] nums) {
        int count = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] == nums[j]) {
                i++;
                j--;
            } else if (nums[i] < nums[j]) {
                nums[i + 1] = nums[i + 1] + nums[i];
                count++;
                i++;
            } else {
                nums[j - 1] = nums[j - 1] + nums[j];
                count++;
                j--;
            }
        }
        return count;
    }
}
