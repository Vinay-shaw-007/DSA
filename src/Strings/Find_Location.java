package Strings;
/*
Problem Statement
Implement a function that takes two strings as input (s and x) and returns the first 0-based index of x within s. Return -1 if x is not found.

You are not allowed to use any in-built functions to solve this problem.

Example 1:
Input:

s = hellohunnybunny, x = hun

Output: 5

Example 2:
Input:

s= bruh, x = r

Output:

1
 */
public class Find_Location {
    public static void main(String[] args) {
        System.out.println(findLocation("codingshuttle","shuttle"));
    }
    public static int findLocation(String s, String x) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x.charAt(0)) {
                boolean isMatch = true;
                for (int j = i + 1; j < x.length() + i; j++) {
                    if (s.charAt(j) != x.charAt(j - i)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) return i;
                i = i + x.length() - 1;
            }
        }
        return -1;
    }
}
