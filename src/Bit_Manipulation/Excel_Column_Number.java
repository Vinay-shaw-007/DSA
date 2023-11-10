package Bit_Manipulation;

/*
Problem Statement
Given a column title A as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
Example 1:
Input:

columnTitle = "A"

Output:

1
 */

public class Excel_Column_Number {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
    public static long titleToNumber(String s) {
        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ans = (ans * 26) + (ch - 'A' + 1);
        }

        return ans;
    }
}
