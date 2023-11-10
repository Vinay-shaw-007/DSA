package Binary_Search;
/*
Problem Statement
You are given N books, you have to create a maximum number of stacks of books using these books, frst stack will contain one book, second stack will contain two books and so on.



Find and return the maximum number of stacks.

Example 1:
Input:

66

Output

11

Explanation:

In this scenario, the input is 66 books, and the task is to create the maximum number of stacks, with each stack having an increasing number of books (the first stack contains one book, the second stack contains two books, and so on). To determine the maximum number of stacks, we need to calculate how many complete stacks can be formed with 66 books, following this pattern. This involves finding the largest value of k (number of stacks) such that the sum of the first k natural numbers (1 + 2 + 3 + ... + k) does not exceed 66. The output represents this maximum number of stacks that can be created using the given input.

Example 2:
Input:

872

Output:

41

Constraints:
0 <= N <= 109
 */
public class Maximum_Stacks {
    public static void main(String[] args) {
        System.out.println(maxStacks(66));
    }
    public static int maxStacks(int N) {
        int ans = -1;
        int l = 0, r = N;
        while (l <= r) {
            int mid = l + (r - l)/2;
            long sumOfNaturalNumber = (long) mid*(mid+1)/2;
            if (sumOfNaturalNumber == N) return mid;
            if (sumOfNaturalNumber < N) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
}
