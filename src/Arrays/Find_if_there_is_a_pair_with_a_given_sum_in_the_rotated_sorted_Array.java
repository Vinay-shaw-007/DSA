package Arrays;

public class Find_if_there_is_a_pair_with_a_given_sum_in_the_rotated_sorted_Array {
    public static void main(String[] args) {
        int[] nums = {11, 15, 26, 38, 9, 10};
        int sum = 45;
        System.out.println(findPair(nums, nums.length,sum));
    }

    private static boolean findPair(int[] nums, int n, int sum) {
        int i = 0,smallNo, largeNo;
        for (i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
        } 
        smallNo = (i+1)%n;
        largeNo = i;
        while(smallNo != largeNo) {
            int currSum = nums[smallNo] + nums[largeNo];
            if (currSum == sum) {
                return true;
            }

            if(currSum < sum) {
                smallNo = (smallNo+1)%n;
            } else {
                largeNo = (n + largeNo - 1)%n;
            }
        }
        return false;
    }
}
