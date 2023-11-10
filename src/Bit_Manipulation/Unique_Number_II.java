package Bit_Manipulation;

/*
Problem Statement
Find the unique number that appears only once in an array where all other elements appear three times, using a linear runtime complexity and constant extra space.

Example 1:
Input:

[-1, -1, 3, 3, -1, 3, 4]

Output:

4

Explanation:

Here every number is present 3 times except the number 4

Example 2:
Input:

[5, 5, 5, 2]

Output:

2
 */
public class Unique_Number_II {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 3, 3, -1, 3, 4};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int e : nums) {
                if ((e & (1 << i)) != 0) count++;
            }
            if (count % 3 != 0) ans = ans | 1 << i;
        }

        return ans;
    }
}
