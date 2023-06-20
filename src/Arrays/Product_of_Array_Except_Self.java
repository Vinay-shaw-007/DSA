package Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };

        for (int productExceptSelf : productExceptSelf(nums))
            System.out.print(productExceptSelf + ",");
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int hasZeroInNums = 0;
        int productOfAllNums = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                hasZeroInNums++;
                continue;
            }
            productOfAllNums *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (hasZeroInNums == 0) {
                ans[i] = (productOfAllNums / nums[i]);
            } else if (hasZeroInNums == 1) {
                if (nums[i] == 0)
                    ans[i] = productOfAllNums;
                else
                    ans[i] = 0;
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }
}
