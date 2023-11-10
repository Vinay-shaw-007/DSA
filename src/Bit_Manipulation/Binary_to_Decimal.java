package Bit_Manipulation;
/*
Problem Statement
Given a Binary Number B in a String format, return its decimal equivalent.

Example 1:
Input:

N = 10

Output:

2

Explanation: The decimal equivalent of '10' is 2.

Example 2:
Input:

N = 10010

Output:

18

Explanation: The decimal equivalent of '10010' is 18.

Constraints:
1 <= number of bits in binary number  <= 32
 */
public class Binary_to_Decimal {
    public static void main(String[] args) {
        System.out.println(toDecimal("1111"));
    }
    public static int toDecimal(String str) {
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                ans += (1 << str.length() -1 -i);
        }

        return ans;
    }
}
